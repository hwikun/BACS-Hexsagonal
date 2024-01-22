package com.hwikun.bacs.auth.web.controller;

import com.hwikun.bacs.auth.web.dto.AuthenticationDto.SignUpRequestDto;
import com.hwikun.bacs.auth.web.dto.AuthenticationDto.SignUpResponseDto;
import com.hwikun.bacs.auth.web.service.AuthenticationProxyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/auth")
public final class AuthenticationApi {
    private final AuthenticationProxyService authenticationProxyService;

    @PostMapping("/sign-up")
    public SignUpResponseDto signUp(@RequestBody SignUpRequestDto dto) {
        boolean isSuccess = authenticationProxyService.signUp(dto);

        return SignUpResponseDto.builder()
                .isSuccess(isSuccess)
                .build();
    }

}
