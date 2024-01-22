package com.hwikun.bacs.auth.application.usecase;

import com.hwikun.bacs.auth.domain.Account;

public interface AuthenticationUseCase {
    Account signUp(Account account);
}
