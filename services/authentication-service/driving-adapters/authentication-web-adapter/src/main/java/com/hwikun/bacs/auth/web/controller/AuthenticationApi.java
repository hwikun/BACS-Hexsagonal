package com.hwikun.bacs.auth.web.controller;

import com.hwikun.bacs.auth.application.data.Tokens;
import com.hwikun.bacs.auth.domain.types.AccountStatus;
import com.hwikun.bacs.auth.web.dto.AuthenticationDto.ChangePasswordRequestDto;
import com.hwikun.bacs.auth.web.dto.AuthenticationDto.ChangePasswordResponseDto;
import com.hwikun.bacs.auth.web.dto.AuthenticationDto.SignInRequestDto;
import com.hwikun.bacs.auth.web.dto.AuthenticationDto.SignInResponseDto;
import com.hwikun.bacs.auth.web.dto.AuthenticationDto.SignUpRequestDto;
import com.hwikun.bacs.auth.web.dto.AuthenticationDto.SignUpResponseDto;
import com.hwikun.bacs.auth.web.service.AuthenticationProxyService;
import com.hwikun.bacs.core.timer.ExeTimer;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/auth")
@ExeTimer
public class AuthenticationApi {
    private final AuthenticationProxyService authenticationProxyService;

    @PostMapping("/sign-up")
    public SignUpResponseDto signUp(
            @RequestBody SignUpRequestDto dto
    ) {
        boolean isSuccess = authenticationProxyService
                .signUp(dto, AccountStatus.ACTIVE) != null;

        return SignUpResponseDto.builder()
                .isSuccess(isSuccess)
                .build();
    }

    @PostMapping("/sign-in")
    public SignInResponseDto signIn(
            @RequestBody SignInRequestDto body,
            HttpServletResponse response
    ) {
        Tokens tokens = authenticationProxyService.signIn(body);

        Cookie refreshTokenCookie = new Cookie("refresh_token", tokens.refreshToken());
        refreshTokenCookie.setDomain("");
        refreshTokenCookie.setPath("/");
        refreshTokenCookie.setHttpOnly(true);
//        refreshTokenCookie.setSecure(true);
        refreshTokenCookie.setMaxAge(2_592_000);
        response.addCookie(refreshTokenCookie);

        return SignInResponseDto.builder()
                .accessToken(tokens.accessToken())
                .build();
    }

    @PostMapping("/change-password")
    public ChangePasswordResponseDto changePassword(@RequestBody ChangePasswordRequestDto dto) {
        boolean isSuccess = authenticationProxyService.changePassword(dto);

        return ChangePasswordResponseDto.builder()
                .isSuccess(isSuccess)
                .build();
    }
}
