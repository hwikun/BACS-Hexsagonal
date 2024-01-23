package com.hwikun.bacs.auth.application.usecase;

import com.hwikun.bacs.auth.application.data.Tokens;
import com.hwikun.bacs.auth.domain.Account;

public interface AuthenticationUseCase {
    Account signUp(Account account);
    Tokens signIn(String username, String rawPassword);
//    Account changePassword(String username, String newPassword);
}
