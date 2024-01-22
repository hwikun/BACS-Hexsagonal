package com.hwikun.bacs.auth.exception;

import com.hwikun.bacs.common.exception.CustomException;
import com.hwikun.bacs.common.exception.ErrorCode;

public class AuthenticationException extends CustomException {
    public AuthenticationException() {
    }

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthenticationException(ErrorCode errorCode) {
        super(errorCode);
    }

    public AuthenticationException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
