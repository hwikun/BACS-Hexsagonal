package com.hwikun.bacs.admin.web.store.service;

import com.hwikun.bacs.admin.domain.Store;
import com.hwikun.bacs.admin.domain.types.StoreStatus;
import com.hwikun.bacs.admin.web.store.dto.StoreDto.CreateStoreRequestDto;
import com.hwikun.bacs.admin.web.store.dto.StoreDto.DeleteStoreRequestDto;
import com.hwikun.bacs.admin.web.store.dto.StoreDto.UpdateStoreRequestDto;

public interface StoreProxyService {
    Store createStore(CreateStoreRequestDto dto, StoreStatus status);

    boolean deleteStore(DeleteStoreRequestDto dto);

    Store updateStore(UpdateStoreRequestDto dto);
}
