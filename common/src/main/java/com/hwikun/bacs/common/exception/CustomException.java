package com.hwikun.bacs.common.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

    protected final ErrorCode errorCode;

    private static ErrorCode getDefaultErrorCode() {
        return DefaultErrorCodeHolder.DEFAULT_ERROR_CODE;
    }

    private static class DefaultErrorCodeHolder {
        private static final ErrorCode DEFAULT_ERROR_CODE = new ErrorCode() {
            @Override
            public String name() {
                return "SERVER_ERROR";
            }

            @Override
            public HttpStatus defaultHttpStatus() {
                return HttpStatus.INTERNAL_SERVER_ERROR;
            }

            @Override
            public String defaultMessage() {
                return "서버 오류";
            }

            @Override
            public RuntimeException defaultException() {
                return new CustomException(this);
            }

            @Override
            public RuntimeException defaultException(Throwable cause) {
                return new CustomException(this, cause);
            }
        };
    }

    public CustomException() {
        this.errorCode = getDefaultErrorCode();
    }

    public CustomException(String message) {
        super(message);
        this.errorCode = getDefaultErrorCode();
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = getDefaultErrorCode();
    }

    public CustomException(ErrorCode errorCode) {
        super(errorCode.defaultMessage());
        this.errorCode = errorCode;
    }

    public CustomException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.defaultMessage(), cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
