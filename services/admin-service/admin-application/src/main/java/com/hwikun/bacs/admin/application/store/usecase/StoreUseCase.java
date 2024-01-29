package com.hwikun.bacs.admin.application.store.usecase;

import com.hwikun.bacs.admin.domain.Store;

public interface StoreUseCase {
    Store createStore(Store store);
    void deleteStore(Store store);
    Store updateStore(Store store);

}
