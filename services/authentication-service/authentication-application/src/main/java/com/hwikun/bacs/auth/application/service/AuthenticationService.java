package com.hwikun.bacs.auth.application.service;

import com.hwikun.bacs.auth.application.data.Tokens;
import com.hwikun.bacs.auth.application.repository.AccountRepository;
import com.hwikun.bacs.auth.application.repository.PasswordHistoryRepository;
import com.hwikun.bacs.auth.application.repository.RedisRepository;
import com.hwikun.bacs.auth.application.usecase.AuthenticationUseCase;
import com.hwikun.bacs.auth.domain.Account;
import com.hwikun.bacs.auth.domain.PasswordHistory;
import com.hwikun.bacs.auth.domain.types.AccountStatus;
import com.hwikun.bacs.auth.exception.AuthenticationErrorCode;
import com.hwikun.bacs.auth.readmodels.AccountReadModels.SignInReadModel;
import com.hwikun.bacs.core.jwt.JwtProvider;
import com.hwikun.bacs.core.random.service.SecuredRandom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.tokens.Token;

import java.time.Instant;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public final class AuthenticationService implements AuthenticationUseCase {
    private final AccountRepository accountRepository;
    private final PasswordHistoryRepository historyRepository;
    private final RedisRepository redisRepository;
    private final SecuredRandom securedRandom;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Override
    public Account signUp(Account account) {
        if (accountRepository.existsAccount(account)) {
            throw AuthenticationErrorCode.USER_CONFLICT.defaultException();
        }

        String salt = securedRandom.generate(22, true);
        Account newAccount = accountRepository.save(
            Account.builder()
                    .username(account.username)
                    .password(passwordEncoder.encode(account.password))
                    .salt(salt)
                    .status(account.status)
                    .build()
        );
        historyRepository.save(
                PasswordHistory.builder()
                        .accountId(newAccount.getId())
                        .username(newAccount.username)
                        .password(passwordEncoder.encode(salt + account.password))
                        .build()
        );
        return newAccount;
    }

    @Override
    public Tokens signIn(String username, String rawPassword) {
        SignInReadModel signInReadModel =
                accountRepository
                        .findAccount(username)
                        .orElseThrow(AuthenticationErrorCode.USER_NULL::defaultException);
        String dbPassword = signInReadModel.password();
        AccountStatus status = signInReadModel.status();
        boolean isMatched;
        Instant now = Instant.now();

        if (!status.canSignIn()) {
            throw AuthenticationErrorCode.CANNOT_SIGN_IN.defaultException();
        }

        isMatched = passwordEncoder.matches(rawPassword, dbPassword);
        if (!isMatched) {
            throw AuthenticationErrorCode.ID_PW_MISMATCHED.defaultException();
        }

        Map<String, Object> map = Map.of("authority", "USER");
        String accessToken = jwtProvider.generateJwt(username, map, now);
        String refreshToken = securedRandom.generate(30, false);

        redisRepository.save(refreshToken, username);

        return Tokens.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
