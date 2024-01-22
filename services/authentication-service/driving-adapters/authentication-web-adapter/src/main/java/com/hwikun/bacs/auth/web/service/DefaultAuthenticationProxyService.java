package com.hwikun.bacs.auth.web.service;

import com.hwikun.bacs.auth.application.usecase.AuthenticationUseCase;
import com.hwikun.bacs.auth.domain.Account;
import com.hwikun.bacs.auth.domain.types.AccountStatus;
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
    public boolean signUp(SignUpRequestDto dto) {
        Account account = mapper.toDomain(dto.username(), dto.password(), AccountStatus.ACTIVE);
        return authenticationUseCase.signUp(account) != null;
    }
}
