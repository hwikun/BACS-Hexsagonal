package com.hwikun.bacs.auth.application.service;

import com.hwikun.bacs.auth.application.repository.AccountRepository;
import com.hwikun.bacs.auth.application.repository.PasswordHistoryRepository;
import com.hwikun.bacs.auth.application.usecase.AuthenticationUseCase;
import com.hwikun.bacs.auth.domain.Account;
import com.hwikun.bacs.auth.domain.PasswordHistory;
import com.hwikun.bacs.auth.exception.AuthenticationErrorCode;
import com.hwikun.bacs.core.random.service.SecuredRandom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public final class AuthenticationService implements AuthenticationUseCase {
    private final AccountRepository accountRepository;
    private final PasswordHistoryRepository historyRepository;
    private final SecuredRandom securedRandom;
    private final PasswordEncoder passwordEncoder;

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
}
