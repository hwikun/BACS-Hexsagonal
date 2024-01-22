package com.hwikun.bacs.auth.application.repository;

import com.hwikun.bacs.auth.domain.Account;

public interface AccountRepository {
    boolean existsAccount(Account account);

    Account save(Account account);
}
