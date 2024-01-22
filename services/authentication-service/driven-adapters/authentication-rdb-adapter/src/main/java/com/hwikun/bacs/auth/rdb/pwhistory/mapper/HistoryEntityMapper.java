package com.hwikun.bacs.auth.rdb.pwhistory.mapper;

import com.hwikun.bacs.auth.domain.PasswordHistory;
import com.hwikun.bacs.auth.rdb.pwhistory.entity.HistoryEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface HistoryEntityMapper {
    HistoryEntity toEntity(PasswordHistory history);

    PasswordHistory toDomain(HistoryEntity entity);
}
