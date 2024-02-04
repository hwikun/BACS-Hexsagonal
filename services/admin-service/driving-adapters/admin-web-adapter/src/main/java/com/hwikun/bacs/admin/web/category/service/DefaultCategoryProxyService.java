package com.hwikun.bacs.admin.web.category.service;

import com.hwikun.bacs.admin.application.category.usecase.CategoryUseCase;
import com.hwikun.bacs.admin.domain.Category;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.CreateCategoryRequestDto;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.CreateCategoryResponseDto;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.DeleteCategoryRequestDto;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.ReadCategoryListResponseDto;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.ReadCategoryRequestDto;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.ReadCategoryResponseDto;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.UpdateCategoryRequestDto;
import com.hwikun.bacs.admin.web.category.mapper.CategoryDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultCategoryProxyService implements CategoryProxyService {
    private final CategoryDtoMapper mapper;
    private final CategoryUseCase categoryUseCase;
    @Override
    public CreateCategoryResponseDto createCategory(String username, CreateCategoryRequestDto dto) {
        Category category = mapper.toDomain(dto.categoryName());
        Category newCategory = categoryUseCase.createCategory(username, category);
        return CreateCategoryResponseDto.builder()
                .id(newCategory.getId())
                .storeId(newCategory.storeId)
                .categoryName(newCategory.categoryName)
                .build();
    }

    @Override
    public ReadCategoryResponseDto readCategory(String username, ReadCategoryRequestDto dto) {
        Category category = mapper.toDomain(dto.categoryName());
        Category targetCategory = categoryUseCase.readCategory(username, category);

        return ReadCategoryResponseDto.builder()
                .id(targetCategory.getId())
                .categoryName(targetCategory.categoryName)
                .build();
    }

    @Override
    public boolean deleteCategory(String username, DeleteCategoryRequestDto dto) {
        Category category = mapper.toDomain(dto.categoryName());
        categoryUseCase.deleteCategory(username, category);
        return true;
    }

    @Override
    public Category updateCategory(String username, UpdateCategoryRequestDto dto) {
        Category category = mapper.toDomain(dto.categoryName());
        return categoryUseCase.updateCategory(username, category, dto.newCategoryName());
    }

    @Override
    public ReadCategoryListResponseDto readCategoryList(String username) {
        List<Category> categoryList = categoryUseCase.readCategoryList(username);

        return ReadCategoryListResponseDto.builder()
                .categoryList(categoryList)
                .build();
    }
}
