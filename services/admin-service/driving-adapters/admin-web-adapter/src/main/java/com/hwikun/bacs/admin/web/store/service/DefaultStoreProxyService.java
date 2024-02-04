package com.hwikun.bacs.admin.web.store.service;

import com.hwikun.bacs.admin.application.store.usecase.StoreUseCase;
import com.hwikun.bacs.admin.domain.Store;
import com.hwikun.bacs.admin.domain.types.StoreStatus;
import com.hwikun.bacs.admin.web.store.dto.StoreDto.CreateStoreRequestDto;
import com.hwikun.bacs.admin.web.store.dto.StoreDto.DeleteStoreRequestDto;
import com.hwikun.bacs.admin.web.store.dto.StoreDto.UpdateStoreRequestDto;
import com.hwikun.bacs.admin.web.store.mapper.StoreDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultStoreProxyService implements StoreProxyService {
    private final StoreDtoMapper mapper;

    private final StoreUseCase storeUseCase;
    @Override
    public Store createStore(String username, CreateStoreRequestDto dto, StoreStatus status) {
        Store store = mapper.toDomain(username, dto, status);
        return storeUseCase.createStore(store);
    }

    @Override
    public boolean deleteStore(String username, DeleteStoreRequestDto dto) {
        Store store = mapper.toDomain(username, dto);
        storeUseCase.deleteStore(store);
        return true;
    }

    @Override
    public Store updateStore(String username, UpdateStoreRequestDto dto) {
        Store store = mapper.toDomain(username, dto);
        return storeUseCase.updateStore(store);
    }
}
