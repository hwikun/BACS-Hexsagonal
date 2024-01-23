package com.hwikun.bacs.admin.exception.menu;

import com.hwikun.bacs.common.exception.CustomException;
import com.hwikun.bacs.common.exception.ErrorCode;


public class MenuException extends CustomException {
    public MenuException() {}

    public MenuException(String message) {
        super(message);
    }

    public MenuException(String message, Throwable cause) {
        super(message, cause);
    }

    public MenuException(ErrorCode errorCode) {
        super(errorCode);
    }

    public MenuException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
