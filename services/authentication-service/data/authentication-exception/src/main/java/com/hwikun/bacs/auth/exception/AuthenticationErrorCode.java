package com.hwikun.bacs.auth.exception;

import com.hwikun.bacs.common.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum AuthenticationErrorCode implements ErrorCode {
    ;

    private final String message;
    private final HttpStatus status;
    @Override
    public String defaultMessage() {
        return message;
    }

    @Override
    public HttpStatus defaultHttpStatus() {
        return status;
    }

    @Override
    public RuntimeException defaultException() {
        return new AuthenticationException(this);
    }

    @Override
    public RuntimeException defaultException(Throwable cause) {
        return new AuthenticationException(this, cause);
    }
}
