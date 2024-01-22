package com.hwikun.bacs.auth.application.repository;

import com.hwikun.bacs.auth.domain.PasswordHistory;

public interface PasswordHistoryRepository {
    PasswordHistory save(PasswordHistory build);
}
