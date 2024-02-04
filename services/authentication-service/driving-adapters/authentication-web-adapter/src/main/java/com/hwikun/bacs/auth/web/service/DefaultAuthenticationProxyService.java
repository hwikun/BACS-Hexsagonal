package com.hwikun.bacs.auth.web.service;

import com.hwikun.bacs.auth.application.data.Tokens;
import com.hwikun.bacs.auth.application.usecase.AuthenticationUseCase;
import com.hwikun.bacs.auth.domain.Account;
import com.hwikun.bacs.auth.domain.types.AccountStatus;
import com.hwikun.bacs.auth.web.dto.AuthenticationDto.ChangePasswordRequestDto;
import com.hwikun.bacs.auth.web.dto.AuthenticationDto.SignInRequestDto;
import com.hwikun.bacs.auth.web.dto.AuthenticationDto.SignUpRequestDto;
import com.hwikun.bacs.auth.web.mapper.AuthenticationDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultAuthenticationProxyService implements AuthenticationProxyService {
    private final AuthenticationUseCase authenticationUseCase;

    private final AuthenticationDtoMapper mapper;
    @Override
    public Account signUp(SignUpRequestDto dto, AccountStatus status) {
        Account account = mapper.toDomain(dto.username(), dto.password(), AccountStatus.ACTIVE);
        return authenticationUseCase.signUp(account);
    }

    @Override
    public Tokens signIn(SignInRequestDto body) {
        return authenticationUseCase.signIn(body.username(), body.rawPassword());
    }

    @Override
    public boolean changePassword(ChangePasswordRequestDto dto, String username) {
        return authenticationUseCase.changePassword(username, dto.newPassword()) != null;
    }
}
