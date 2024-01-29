package com.hwikun.bacs.admin.application.store.repository;

import com.hwikun.bacs.admin.domain.Store;

import java.util.Optional;

public interface StoreRepository {
    Store save(Store store);

    boolean existsStore(String username);

    Optional<Store> findStoreByUsername(String username);

    void delete(Store target);

    Store updateStore(Store target);
}
