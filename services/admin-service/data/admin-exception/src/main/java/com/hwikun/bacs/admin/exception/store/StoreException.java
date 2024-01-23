package com.hwikun.bacs.admin.exception.store;

import com.hwikun.bacs.common.exception.CustomException;
import com.hwikun.bacs.common.exception.ErrorCode;

public class StoreException extends CustomException {
    public StoreException() {}

    public StoreException(String message) {
        super(message);
    }

    public StoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public StoreException(ErrorCode errorCode) {
        super(errorCode);
    }

    public StoreException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
