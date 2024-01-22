package com.hwikun.bacs.auth.application.data;

import lombok.Builder;

@Builder
public record Tokens(
        String accessToken,
        String refreshToken
) {
}
