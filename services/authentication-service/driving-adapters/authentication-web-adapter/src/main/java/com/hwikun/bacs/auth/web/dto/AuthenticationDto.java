package com.hwikun.bacs.auth.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @Builder
    public record SignInResponseDto(
            @JsonProperty("access_token")
            @JsonInclude(Include.NON_EMPTY)
            String accessToken
    ) {}

    @Builder
    public record SignInRequestDto(
            @NotBlank
            String username,

            @NotBlank
            @JsonProperty("password")
            String rawPassword
    ) {}
}
