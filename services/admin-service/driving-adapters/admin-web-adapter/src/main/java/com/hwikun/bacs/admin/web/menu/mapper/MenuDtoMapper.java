package com.hwikun.bacs.admin.web.menu.mapper;

import com.hwikun.bacs.admin.domain.Menu;
import com.hwikun.bacs.admin.web.menu.dto.MenuDto.CreateMenuRequestDto;
import com.hwikun.bacs.admin.web.menu.dto.MenuDto.DeleteMenuRequestDto;
import com.hwikun.bacs.admin.web.menu.dto.MenuDto.ReadMenuRequestDto;
import com.hwikun.bacs.admin.web.menu.dto.MenuDto.UpdateMenuRequestDto;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface MenuDtoMapper {
    Menu toDomain(CreateMenuRequestDto dto);

    Menu toDomain(ReadMenuRequestDto dto);

    Menu toDomain(DeleteMenuRequestDto dto);

    Menu toDomain(UpdateMenuRequestDto dto);
}
