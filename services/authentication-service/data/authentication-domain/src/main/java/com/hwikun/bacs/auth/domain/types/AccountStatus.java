package com.hwikun.bacs.auth.domain.types;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum AccountStatus {
    PENDING(false),
    ACTIVE(true),
    ADMIN(true),
    PROTECTED(true),
    SUSPENDED(true), // BLOCK
    SLEPT(false),
    REMOVED(false);

    private final boolean canSignIn;

    public boolean canSignIn() {
        return canSignIn;
    }
}
