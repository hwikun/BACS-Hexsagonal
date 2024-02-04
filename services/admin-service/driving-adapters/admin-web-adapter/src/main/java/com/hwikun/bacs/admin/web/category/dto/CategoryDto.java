package com.hwikun.bacs.admin.web.category.dto;

import com.hwikun.bacs.admin.domain.Category;
import lombok.Builder;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import java.util.List;

public final class CategoryDto {
    private CategoryDto() {}

    @Builder
    public record CreateCategoryRequestDto(
            @NotBlank
            String categoryName
    ) {}
    @Builder
    public record CreateCategoryResponseDto(
            String id,
            String storeId,
            String categoryName
    ) {}
    @Builder
    public record ReadCategoryRequestDto(
            @NotBlank
            String categoryName
    ) {}
    @Builder
    public record ReadCategoryResponseDto(
            String id,
            String categoryName
    ) {}
    @Builder
    public record ReadCategoryListResponseDto(
            List<Category> categoryList
    ) {}
    @Builder
    public record UpdateCategoryRequestDto(
            @NotBlank
            String categoryName,
            @NotBlank
            String newCategoryName
    ) {}
    @Builder
    public record UpdateCategoryResponseDto(
            boolean isSuccess
    ) {}
    @Builder
    public record DeleteCategoryRequestDto(
            @NotBlank
            String categoryName
    ) {}
    @Builder
    public record DeleteCategoryResponseDto(
            boolean isSuccess
    ) {}

}
