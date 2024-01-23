package com.hwikun.bacs.admin.exception.menu;

import com.hwikun.bacs.common.exception.ErrorCode;
import org.springframework.http.HttpStatus;

public enum MenuErrorCode implements ErrorCode {
    ;

    private String message;
    private HttpStatus status;
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
        return new MenuException(this);
    }

    @Override
    public RuntimeException defaultException(Throwable cause) {
        return new MenuException(this, cause);
    }
}
