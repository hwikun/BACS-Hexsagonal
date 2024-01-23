package com.hwikun.bacs.auth.rdb.account.projection;

import com.hwikun.bacs.auth.domain.types.AccountStatus;
import lombok.Builder;

public final class AccountProjections {
    private AccountProjections() {}

    @Builder
    public record SignInInfoProjection(
            String password,
            AccountStatus status
    ) {}

    @Builder
    public record SaltProjection(
            String salt
    ) {}
}
