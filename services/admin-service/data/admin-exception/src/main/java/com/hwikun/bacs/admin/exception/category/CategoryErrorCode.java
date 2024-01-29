package com.hwikun.bacs.admin.exception.category;

import com.hwikun.bacs.common.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum CategoryErrorCode implements ErrorCode {
    CATEGORY_NULL("없는 카테고리 입니다", HttpStatus.NOT_FOUND),
    CATEGORY_CONFLICT("중복된 카테고리입니다.", HttpStatus.CONFLICT),
    DEFAULT("알 수 없는 오류", HttpStatus.INTERNAL_SERVER_ERROR);

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
        return new CategoryException(this);
    }

    @Override
    public RuntimeException defaultException(Throwable cause) {
        return new CategoryException(this, cause);
    }
}
