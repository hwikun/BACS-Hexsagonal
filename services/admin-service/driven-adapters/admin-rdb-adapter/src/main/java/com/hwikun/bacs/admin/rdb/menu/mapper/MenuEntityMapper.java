package com.hwikun.bacs.admin.rdb.menu.mapper;

import com.hwikun.bacs.admin.domain.Menu;
import com.hwikun.bacs.admin.rdb.menu.entity.MenuEntity;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface MenuEntityMapper {
    MenuEntity toEntity(Menu menu);
    Menu toDomain(MenuEntity entity);
    List<Menu> toDomain(List<MenuEntity> entityList);
}
