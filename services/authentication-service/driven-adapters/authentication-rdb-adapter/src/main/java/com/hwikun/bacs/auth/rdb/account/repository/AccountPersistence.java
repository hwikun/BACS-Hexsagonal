package com.hwikun.bacs.auth.rdb.account.repository;

import com.hwikun.bacs.auth.application.repository.AccountRepository;
import com.hwikun.bacs.auth.domain.Account;
import com.hwikun.bacs.auth.exception.AuthenticationErrorCode;
import com.hwikun.bacs.auth.rdb.account.entity.AccountEntity;
import com.hwikun.bacs.auth.rdb.account.mapper.AccountEntityMapper;
import com.hwikun.bacs.auth.rdb.account.projection.AccountProjections.SaltProjection;
import com.hwikun.bacs.auth.readmodels.AccountReadModels.AccountSaltReadModel;
import com.hwikun.bacs.auth.readmodels.AccountReadModels.SignInReadModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AccountPersistence implements AccountRepository {
    private final AccountJpaRepository accountJpaRepository;
    private final AccountEntityMapper mapper;
    @Override
    public boolean existsAccount(Account account) {
        AccountEntity entity = mapper.toEntity(account);
        return accountJpaRepository.existsByUsername(entity.username);
    }

    @Override
    public Account save(Account account) {
        AccountEntity entity = accountJpaRepository.save(mapper.toEntity(account));
        return mapper.toDomain(entity);
    }

    @Override
    public Optional<SignInReadModel> findSignInInfo(String username) {
        return accountJpaRepository.findSignInInfoByUsername(username).map(mapper::toReadModel);
    }

    @Override
    public Optional<Account> findAccount(String username) {
        return accountJpaRepository.findByUsername(username)
                .map(mapper::toDomain);
    }

    @Override
    public Account changePassword(String username, String password) {
        AccountEntity entity = accountJpaRepository.findByUsername(username)
                .orElseThrow(AuthenticationErrorCode.USER_NULL::defaultException);
        entity.password = password;
        return mapper.toDomain(entity);
    }

    @Override
    public Optional<AccountSaltReadModel> findAccountSalt(String username) {
        return accountJpaRepository.findSaltByUsername(username)
                .map(mapper::toReadModel);
    }
}
