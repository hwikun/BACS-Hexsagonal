package com.hwikun.bacs.admin.exception.menu;

import com.hwikun.bacs.common.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum MenuErrorCode implements ErrorCode {
    MENU_NULL("없는 메뉴 입니다", HttpStatus.NOT_FOUND),
    MENU_CONFLICT("중복된 메뉴입니다.", HttpStatus.CONFLICT),
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
        return new MenuException(this);
    }

    @Override
    public RuntimeException defaultException(Throwable cause) {
        return new MenuException(this, cause);
    }
}
