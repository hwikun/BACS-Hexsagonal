package com.hwikun.bacs.auth.rdb.account.repository;

import com.hwikun.bacs.auth.domain.Account;
import com.hwikun.bacs.auth.rdb.account.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountJpaRepository extends JpaRepository<AccountEntity, UUID> {
    boolean existsByUsername(String username);
}
