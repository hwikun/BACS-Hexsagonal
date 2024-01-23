package com.hwikun.bacs.auth.readmodels;

import com.hwikun.bacs.auth.domain.types.AccountStatus;
import lombok.Builder;

public final class AccountReadModels {
    private AccountReadModels() {}

    @Builder
    public record SignInReadModel(
            String password,
            AccountStatus status
    ) {}

    @Builder
    public record AccountSaltReadModel(
            String salt
    ) {}
}
