package com.hwikun.bacs.admin.web.store.mapper;

import com.hwikun.bacs.admin.domain.Store;
import com.hwikun.bacs.admin.domain.types.StoreStatus;
import com.hwikun.bacs.admin.web.store.dto.StoreDto.CreateStoreRequestDto;
import com.hwikun.bacs.admin.web.store.dto.StoreDto.DeleteStoreRequestDto;
import com.hwikun.bacs.admin.web.store.dto.StoreDto.UpdateStoreRequestDto;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface StoreDtoMapper {

    Store toDomain(String username, CreateStoreRequestDto dto, StoreStatus status);

    Store toDomain(String username, UpdateStoreRequestDto dto);

    Store toDomain(String username, DeleteStoreRequestDto dto);
}
