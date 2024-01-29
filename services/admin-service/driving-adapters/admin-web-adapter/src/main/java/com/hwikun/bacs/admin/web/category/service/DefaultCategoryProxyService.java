package com.hwikun.bacs.admin.web.category.service;

import com.hwikun.bacs.admin.application.category.usecase.CategoryUseCase;
import com.hwikun.bacs.admin.domain.Category;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.CreateCategoryRequestDto;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.CreateCategoryResponseDto;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.DeleteCategoryRequestDto;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.ReadCategoryListRequestDto;
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
    public CreateCategoryResponseDto createCategory(CreateCategoryRequestDto dto) {
        Category category = mapper.toDomain(dto.categoryName());
        Category newCategory = categoryUseCase.createCategory(dto.username(), category);
        return CreateCategoryResponseDto.builder()
                .id(newCategory.getId())
                .storeId(newCategory.storeId)
                .categoryName(newCategory.categoryName)
                .build();
    }

    @Override
    public ReadCategoryResponseDto readCategory(ReadCategoryRequestDto dto) {
        Category category = mapper.toDomain(dto.categoryName());
        Category targetCategory = categoryUseCase.readCategory(dto.username(), category);

        return ReadCategoryResponseDto.builder()
                .id(targetCategory.getId())
                .categoryName(targetCategory.categoryName)
                .build();
    }

    @Override
    public boolean deleteCategory(DeleteCategoryRequestDto dto) {
        Category category = mapper.toDomain(dto.categoryName());
        categoryUseCase.deleteCategory(dto.username(), category);
        return true;
    }

    @Override
    public Category updateCategory(UpdateCategoryRequestDto dto) {
        Category category = mapper.toDomain(dto.categoryName());
        return categoryUseCase.updateCategory(dto.username(), category, dto.newCategoryName());
    }

    @Override
    public ReadCategoryListResponseDto readCategoryList(ReadCategoryListRequestDto dto) {
        List<Category> categoryList = categoryUseCase.readCategoryList(dto.username());

        return ReadCategoryListResponseDto.builder()
                .categoryList(categoryList)
                .build();
    }
}
