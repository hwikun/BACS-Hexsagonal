package com.hwikun.bacs.admin.rdb.store.repository;

import com.hwikun.bacs.admin.rdb.store.entity.StoreEntity;
import org.antlr.v4.runtime.misc.MultiMap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StoreJpaRepository extends JpaRepository<StoreEntity, UUID> {
    boolean existsByUsername(String username);
    Optional<StoreEntity> findByUsername(String username);

    Optional<StoreEntity> findByStoreName(String storeName);
}
