package com.hwikun.bacs.auth.web.service;

import com.hwikun.bacs.auth.web.dto.AuthenticationDto.SignUpRequestDto;

public interface AuthenticationProxyService {
    boolean signUp(SignUpRequestDto dto);
}
