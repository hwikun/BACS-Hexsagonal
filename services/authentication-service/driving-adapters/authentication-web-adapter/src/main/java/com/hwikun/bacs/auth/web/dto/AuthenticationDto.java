package com.hwikun.bacs.auth.web.dto;

import lombok.Builder;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

public final class AuthenticationDto {
    private AuthenticationDto() {}

    @Builder
    public record SignUpRequestDto(
            @NotBlank
            String username,
            @NotBlank
            String password
    ) {}

    @Builder
    public record SignUpResponseDto(
            boolean isSuccess
    ) {}
}
