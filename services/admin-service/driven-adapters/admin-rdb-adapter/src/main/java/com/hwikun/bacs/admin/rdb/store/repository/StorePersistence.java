package com.hwikun.bacs.admin.rdb.store.repository;

import com.hwikun.bacs.admin.application.store.repository.StoreRepository;
import com.hwikun.bacs.admin.domain.Store;
import com.hwikun.bacs.admin.exception.store.StoreErrorCode;
import com.hwikun.bacs.admin.rdb.store.entity.StoreEntity;
import com.hwikun.bacs.admin.rdb.store.mapper.StoreEntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Slf4j
@Transactional
public class StorePersistence implements StoreRepository {
    private final StoreJpaRepository storeJpaRepository;
    private final StoreEntityMapper mapper;
    @Override
    public Store save(Store store) {
        StoreEntity entity = storeJpaRepository.save(mapper.toEntity(store));
        return mapper.toDomain(entity);
    }

    @Override
    public boolean existsStore(String username) {
        return storeJpaRepository.existsByUsername(username);
    }

    @Override
    public Optional<Store> findStoreByUsername(String username) {
        return storeJpaRepository.findByUsername(username)
                .map(mapper::toDomain);
    }

    @Override
    public void delete(Store store) {
        StoreEntity entity = storeJpaRepository.findByUsername(store.username)
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);
        log.debug("delete entity: {}", entity);
        storeJpaRepository.delete(entity);
    }

    @Override
    public Store updateStore(Store store) {
        StoreEntity targetEntity = storeJpaRepository.findByUsername(store.username)
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);

//        if (store.storeName != null) {
            targetEntity.storeName = store.storeName;
//        }
//        if (store.address != null) {
            targetEntity.address = store.address;
//        }
//        if (store.storeDigit != null) {
            targetEntity.storeDigit = store.storeDigit;
//        }
//        if (store.status != null) {
            targetEntity.status = store.status;
//        }
        return mapper.toDomain(targetEntity);
    }
}
