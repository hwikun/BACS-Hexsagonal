package com.hwikun.bacs.auth.rdb.account.repository;

import com.hwikun.bacs.auth.domain.Account;
import com.hwikun.bacs.auth.rdb.account.entity.AccountEntity;
import com.hwikun.bacs.auth.rdb.account.projection.AccountProjections.SignInInfoProjection;
import com.hwikun.bacs.auth.readmodels.AccountReadModels.SignInReadModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountJpaRepository extends JpaRepository<AccountEntity, UUID> {
    boolean existsByUsername(String username);
    Optional<AccountEntity> findByUsername(String username);
    Optional<SignInInfoProjection> findSignInInfoByUsername(String username);
}
