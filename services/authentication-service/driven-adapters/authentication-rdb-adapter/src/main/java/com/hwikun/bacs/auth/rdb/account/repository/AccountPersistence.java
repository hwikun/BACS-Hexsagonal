package com.hwikun.bacs.auth.rdb.account.repository;

import com.hwikun.bacs.auth.application.repository.AccountRepository;
import com.hwikun.bacs.auth.domain.Account;
import com.hwikun.bacs.auth.rdb.account.entity.AccountEntity;
import com.hwikun.bacs.auth.rdb.account.mapper.AccountEntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}
