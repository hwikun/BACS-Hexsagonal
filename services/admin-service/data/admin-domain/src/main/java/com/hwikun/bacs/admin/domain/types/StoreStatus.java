package com.hwikun.bacs.admin.domain.types;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum StoreStatus {
    ACTIVE(true),
    PROTECTED(true),
    SUSPENDED(false),
    REMOVED(false);

    private final boolean canAccess;

    public boolean canAccess() {
        return canAccess;
    }
}
