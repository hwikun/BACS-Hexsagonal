package com.hwikun.bacs.admin.rdb.store.mapper;

import com.hwikun.bacs.admin.domain.Store;
import com.hwikun.bacs.admin.rdb.store.entity.StoreEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface StoreEntityMapper {
    StoreEntity toEntity(Store store);

    Store toDomain(StoreEntity entity);
}
