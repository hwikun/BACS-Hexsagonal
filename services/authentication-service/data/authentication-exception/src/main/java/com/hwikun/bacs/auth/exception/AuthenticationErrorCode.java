package com.hwikun.bacs.auth.exception;

import com.hwikun.bacs.common.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum AuthenticationErrorCode implements ErrorCode {
    ID_PW_MISMATCHED("아이디 혹은 패스워드가 일치하지 않습니다.", HttpStatus.BAD_REQUEST),
    DEFAULT("인증 실패", HttpStatus.INTERNAL_SERVER_ERROR),
    USER_CONFLICT("중복된 아이디 입니다", HttpStatus.CONFLICT),
    USER_NULL("유저가 존재하지 않습니다.", HttpStatus.NOT_FOUND),
    PASSWORD_HISTORY_NULL("찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    CANNOT_SIGN_IN("로그인 할 수 없는 아이디 입니다", HttpStatus.FORBIDDEN),
    HISTORY_CONFLICT("이전에 설정한 비밀번호는 설정할 수 없습니다.", HttpStatus.CONFLICT);

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
        return new AuthenticationException(this);
    }

    @Override
    public RuntimeException defaultException(Throwable cause) {
        return new AuthenticationException(this, cause);
    }
}
