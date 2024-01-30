package com.hwikun.bacs.admin.web.menu.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hwikun.bacs.admin.domain.Menu;
import lombok.Builder;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import java.util.List;

public final class MenuDto {
    private MenuDto() {}

    @Builder
    public record CreateMenuRequestDto(
            @NotBlank
            String categoryId,
            @NotBlank
            String menuName,
            @NotBlank
            int menuPrice,
            @JsonInclude(Include.NON_NULL)
            String menuDesc,
            @JsonInclude(Include.NON_NULL)
            String menuImg
    ) {}
    @Builder
    public record CreateMenuResponseDto(
            String id,
            String categoryId,
            String menuName,
            int menuPrice,
            String menuDesc,
            String menuImg
    ) {}
    @Builder
    public record ReadMenuRequestDto(
            @NotBlank
            String categoryId,
            @NotBlank
            String menuName
    ) {}
    @Builder
    public record ReadMenuResponseDto(
            @JsonInclude(Include.NON_EMPTY)
            String id,
            @JsonInclude(Include.NON_EMPTY)
            String menuName,
            @JsonInclude(Include.NON_EMPTY)
            int menuPrice,
            @JsonInclude(Include.NON_NULL)
            String menuDesc,
            @JsonInclude(Include.NON_NULL)
            String menuImg
    ) {}
    @Builder
    public record ReadMenuListRequestDto(
            @NotBlank
            String categoryId
    ) {}
    @Builder
    public record ReadMenuListResponseDto(
            List<Menu> menuList
    ) {}
    @Builder
    public record DeleteMenuRequestDto(
            @NotBlank
            String categoryId,
            @NotBlank
            String menuName
    ) {}
    @Builder
    public record DeleteMenuResponseDto(
            boolean isSuccess
    ) {}
    @Builder
    public record UpdateMenuRequestDto(
            @NotBlank
            String categoryId,
            @NotBlank
            String menuName,
            @JsonInclude(Include.NON_NULL)
            int menuPrice,
            @JsonInclude(Include.NON_NULL)
            int menuDesc,
            @JsonInclude(Include.NON_NULL)
            int menuImg
    ) {}
    @Builder
    public record UpdateMenuResponseDto(
            boolean isSuccess
    ) {}

}
