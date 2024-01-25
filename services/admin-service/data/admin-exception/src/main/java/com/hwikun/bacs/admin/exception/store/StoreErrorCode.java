package com.hwikun.bacs.admin.exception.store;

import com.hwikun.bacs.admin.exception.option.OptionException;
import com.hwikun.bacs.common.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum StoreErrorCode implements ErrorCode {
    STORE_CONFLICT("매장이 존재합니다", HttpStatus.CONFLICT),
    STORE_NULL("매장이 존재하지 않습니다", HttpStatus.NOT_FOUND),
    DEFAULT("알 수 없는 오류", HttpStatus.INTERNAL_SERVER_ERROR),
    CANNOT_ACCESS("제한된 매장입니다. 관리자에게 문의하세요", HttpStatus.BAD_REQUEST);


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
        return new OptionException(this);
    }

    @Override
    public RuntimeException defaultException(Throwable cause) {
        return new OptionException(this, cause);
    }
}
