package com.hwikun.bacs.admin.exception.option;

import com.hwikun.bacs.common.exception.CustomException;
import com.hwikun.bacs.common.exception.ErrorCode;

public class OptionException extends CustomException {
    public OptionException() {}

    public OptionException(String message) {
        super(message);
    }

    public OptionException(String message, Throwable cause) {
        super(message, cause);
    }

    public OptionException(ErrorCode errorCode) {
        super(errorCode);
    }

    public OptionException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
