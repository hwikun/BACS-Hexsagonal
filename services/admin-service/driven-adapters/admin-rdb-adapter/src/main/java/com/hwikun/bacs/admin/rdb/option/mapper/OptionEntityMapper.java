package com.hwikun.bacs.admin.rdb.option.mapper;

import com.hwikun.bacs.admin.domain.Option;
import com.hwikun.bacs.admin.rdb.option.entity.OptionEntity;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface OptionEntityMapper {
    OptionEntity toEntity(Option option);

    Option toDomain(OptionEntity entity);

    List<Option> toDomain(List<OptionEntity> entityList);
}
