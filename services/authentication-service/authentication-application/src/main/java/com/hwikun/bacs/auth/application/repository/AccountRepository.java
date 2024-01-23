package com.hwikun.bacs.auth.application.repository;

import com.hwikun.bacs.auth.domain.Account;
import com.hwikun.bacs.auth.readmodels.AccountReadModels.SignInReadModel;

import java.util.Optional;

public interface AccountRepository {
    boolean existsAccount(Account account);

    Account save(Account account);

    Optional<SignInReadModel> findAccount(String username);
}
