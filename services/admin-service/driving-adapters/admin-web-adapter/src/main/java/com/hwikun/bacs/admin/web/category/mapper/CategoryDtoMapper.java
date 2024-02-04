package com.hwikun.bacs.admin.web.category.mapper;

import com.hwikun.bacs.admin.domain.Category;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.CreateCategoryRequestDto;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.ReadCategoryRequestDto;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface CategoryDtoMapper {
    Category toDomain(CreateCategoryRequestDto dto);

    Category toDomain(ReadCategoryRequestDto dto);

    Category toDomain(String username, String categoryName);

    Category toDomain(String categoryName);
}
