package com.hwikun.bacs.auth.web.service;

import com.hwikun.bacs.auth.application.data.Tokens;
import com.hwikun.bacs.auth.domain.Account;
import com.hwikun.bacs.auth.domain.types.AccountStatus;
import com.hwikun.bacs.auth.web.dto.AuthenticationDto.ChangePasswordRequestDto;
import com.hwikun.bacs.auth.web.dto.AuthenticationDto.SignInRequestDto;
import com.hwikun.bacs.auth.web.dto.AuthenticationDto.SignUpRequestDto;

public interface AuthenticationProxyService {
    Account signUp(SignUpRequestDto dto, AccountStatus status);

    Tokens signIn(SignInRequestDto body);

    boolean changePassword(ChangePasswordRequestDto dto, String username);
}
