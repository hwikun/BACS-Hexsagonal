package com.hwikun.bacs.admin.web.option.mapper;

import com.hwikun.bacs.admin.domain.Option;
import com.hwikun.bacs.admin.web.option.dto.OptionDto.CreateOptionRequestDto;
import com.hwikun.bacs.admin.web.option.dto.OptionDto.DeleteOptionRequestDto;
import com.hwikun.bacs.admin.web.option.dto.OptionDto.ReadOptionRequestDto;
import com.hwikun.bacs.admin.web.option.dto.OptionDto.UpdateOptionRequestDto;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface OptionDtoMapper {
    Option toDomain(CreateOptionRequestDto dto);

    Option toDomain(ReadOptionRequestDto dto);

    Option toDomain(DeleteOptionRequestDto dto);

    Option toDomain(UpdateOptionRequestDto dto);
}
