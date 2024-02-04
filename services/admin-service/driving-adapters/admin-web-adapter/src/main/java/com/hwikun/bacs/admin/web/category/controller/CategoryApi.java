package com.hwikun.bacs.admin.web.category.controller;

import com.hwikun.bacs.admin.web.category.dto.CategoryDto.CreateCategoryRequestDto;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.CreateCategoryResponseDto;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.DeleteCategoryRequestDto;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.DeleteCategoryResponseDto;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.ReadCategoryListResponseDto;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.ReadCategoryRequestDto;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.ReadCategoryResponseDto;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.UpdateCategoryRequestDto;
import com.hwikun.bacs.admin.web.category.dto.CategoryDto.UpdateCategoryResponseDto;
import com.hwikun.bacs.admin.web.category.service.CategoryProxyService;
import com.hwikun.bacs.core.jwt.JwtUsername;
import com.hwikun.bacs.core.timer.ExeTimer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@ExeTimer
@RequestMapping("api/admin/category")
public class CategoryApi {
    private final CategoryProxyService categoryProxyService;

    @PostMapping("/create")
    public CreateCategoryResponseDto createCategory(
            @RequestBody @Valid CreateCategoryRequestDto dto,
            @JwtUsername @Valid String username
    ) {
        return categoryProxyService.createCategory(username, dto);
    }

    @GetMapping("/read")
    public ReadCategoryResponseDto readCategory(
            @RequestBody @Valid ReadCategoryRequestDto dto,
            @JwtUsername @Valid String username
    ) {
        return categoryProxyService.readCategory(username, dto);
    }

    @GetMapping("/read-all")
    public ReadCategoryListResponseDto readAllCategory(
            @JwtUsername @Valid String username
    ) {
        return categoryProxyService.readCategoryList(username);
    }

    @PostMapping("/delete")
    public DeleteCategoryResponseDto deleteCategory(
            @RequestBody @Valid DeleteCategoryRequestDto dto,
            @JwtUsername @Valid String username
    ) {
        boolean isSuccess = categoryProxyService.deleteCategory(username, dto);

        return DeleteCategoryResponseDto.builder()
                .isSuccess(isSuccess)
                .build();
    }

    @PostMapping("/update")
    public UpdateCategoryResponseDto updateCategory(
            @RequestBody @Valid UpdateCategoryRequestDto dto,
            @JwtUsername @Valid String username
    ) {
        boolean isSuccess = categoryProxyService.updateCategory(username, dto) != null;

        return UpdateCategoryResponseDto.builder()
                .isSuccess(isSuccess)
                .build();
    }
}
