package com.hwikun.bacs.admin.web.category.service;

import com.hwikun.bacs.admin.domain.Category;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.CreateCategoryRequestDto;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.CreateCategoryResponseDto;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.DeleteCategoryRequestDto;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.ReadCategoryListResponseDto;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.ReadCategoryRequestDto;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.ReadCategoryResponseDto;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.UpdateCategoryRequestDto;

public interface CategoryProxyService {
    CreateCategoryResponseDto createCategory(String username, CreateCategoryRequestDto dto);

    ReadCategoryResponseDto readCategory(String username, ReadCategoryRequestDto dto);

    boolean deleteCategory(String username, DeleteCategoryRequestDto dto);

    Category updateCategory(String username, UpdateCategoryRequestDto dto);

    ReadCategoryListResponseDto readCategoryList(String username);
}
