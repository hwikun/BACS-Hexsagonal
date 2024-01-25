package com.hwikun.bacs.admin.web.store.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hwikun.bacs.admin.domain.types.StoreStatus;
import lombok.Builder;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

public final class StoreDto {
    private StoreDto() {}

    @Builder
    public record CreateStoreRequestDto(
            @NotBlank
            String username,
            @NotBlank
            String storeName,
            @NotBlank
            String address,
            @NotBlank
            String storeDigit
    ) {}
    @Builder
    public record CreateStoreResponseDto(
            boolean isSuccess
    ) {}
    @Builder
    public record DeleteStoreRequestDto(
            @NotBlank
            String username
    ) {}
    @Builder
    public record DeleteStoreResponseDto(
            boolean isSuccess
    ) {}
    @Builder
    public record UpdateStoreRequestDto(
            @NotBlank
            String username,
            @JsonInclude(Include.NON_NULL)
            String storeName,
            @JsonInclude(Include.NON_NULL)
            String address,
            @JsonInclude(Include.NON_NULL)
            String storeDigit,
            @JsonInclude(Include.NON_NULL)
            StoreStatus status
    ) {}
    @Builder
    public record UpdateStoreResponseDto(
            boolean isSuccess
    ) {}

}
