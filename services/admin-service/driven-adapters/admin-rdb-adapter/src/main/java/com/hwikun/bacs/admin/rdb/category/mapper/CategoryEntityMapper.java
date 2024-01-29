package com.hwikun.bacs.admin.rdb.category.mapper;

import com.hwikun.bacs.admin.domain.Category;
import com.hwikun.bacs.admin.rdb.category.entity.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface CategoryEntityMapper {
    CategoryEntity toEntity(Category category);

    Category toDomain(CategoryEntity entity);

    List<Category> toDomain(List<CategoryEntity> entityList);
}
