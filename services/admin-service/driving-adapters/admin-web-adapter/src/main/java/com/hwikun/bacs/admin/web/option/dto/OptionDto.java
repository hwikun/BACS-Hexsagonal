package com.hwikun.bacs.admin.web.option.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hwikun.bacs.admin.domain.Option;
import lombok.Builder;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import java.util.List;

public final class OptionDto {
    private OptionDto() {}

    @Builder
    public record CreateOptionResponseDto(
            String id,
            String menuId,
            String optionName,
            String optionValue,
            int    optionPrice,
            String optionDesc
    ) {}
    @Builder
    public record CreateOptionRequestDto(
            @NotBlank
            String menuId,
            @NotBlank
            String optionName,
            @NotBlank
            String optionValue,
            @NotBlank
            int    optionPrice,
            @JsonInclude(Include.NON_NULL)
            String optionDesc
    ) {}
    @Builder
    public record ReadOptionResponseDto(
            String id,
            String menuId,
            String optionName,
            String optionValue,
            int    optionPrice,
            String optionDesc
    ) {}
    @Builder
    public record ReadOptionRequestDto(
            @NotBlank
            String menuId,
            @NotBlank
            String optionName,
            @NotBlank
            String optionValue
    ) {}
    @Builder
    public record ReadOptionListResponseDto(
            List<Option> optionList
    ) {}
    @Builder
    public record ReadOptionListRequestDto(
            @NotBlank
            String menuId
    ) {}
    @Builder
    public record DeleteOptionResponseDto(
            boolean isSuccess
    ) {}
    @Builder
    public record DeleteOptionRequestDto(
            @NotBlank
            String menuId,
            @NotBlank
            String optionName,
            @NotBlank
            String optionValue
    ) {}
    @Builder
    public record UpdateOptionResponseDto(
            boolean isSuccess
    ) {}
    @Builder
    public record UpdateOptionRequestDto(
            @NotBlank
            String menuId,
            @NotBlank
            String optionName,
            @NotBlank
            String optionValue,
            @JsonInclude(Include.NON_NULL)
            int    optionPrice,
            @JsonInclude(Include.NON_NULL)
            String optionDesc
    ) {}

}
