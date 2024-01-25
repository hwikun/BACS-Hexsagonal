package com.hwikun.bacs.admin.application.store.service;

import com.hwikun.bacs.admin.application.store.repository.StoreRepository;
import com.hwikun.bacs.admin.application.store.usecase.StoreUseCase;
import com.hwikun.bacs.admin.domain.Store;
import com.hwikun.bacs.admin.exception.store.StoreErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StoreService implements StoreUseCase {
    private final StoreRepository storeRepository;
    @Override
    public Store createStore(Store store) {
        log.debug("create store: {}", store);
        if (storeRepository.existsStore(store.username)) {
            throw StoreErrorCode.STORE_CONFLICT.defaultException();
        }
        return storeRepository.save(store);
    }

    @Override
    public void deleteStore(String username) {
        Store target = storeRepository.findStore(username)
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);
        storeRepository.delete(target);
    }

    @Override
    public Store updateStore(Store store) {
        Store target = storeRepository.findStore(store.username)
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);

        if (store.storeName != null) {
            target.storeName = store.storeName;
        }
        if (store.address != null) {
            target.address = store.address;
        }
        if (store.storeDigit != null) {
            target.storeDigit = store.storeDigit;
        }
        if (store.status != null) {
            target.status = store.status;
        }
        log.debug("target: {}", target);

        return storeRepository.updateStore(target);
    }
}
