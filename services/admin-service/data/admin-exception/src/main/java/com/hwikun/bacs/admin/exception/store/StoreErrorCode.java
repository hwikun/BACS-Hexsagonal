package com.hwikun.bacs.admin.exception.store;

import com.hwikun.bacs.admin.exception.option.OptionException;
import com.hwikun.bacs.common.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum StoreErrorCode implements ErrorCode {
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
        return new OptionException(this);
    }

    @Override
    public RuntimeException defaultException(Throwable cause) {
        return new OptionException(this, cause);
    }
}
