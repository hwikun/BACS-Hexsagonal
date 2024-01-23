package com.hwikun.bacs.auth.application.repository;

import com.hwikun.bacs.auth.domain.PasswordHistory;

import java.util.List;

public interface PasswordHistoryRepository {
    PasswordHistory save(PasswordHistory build);

    List<PasswordHistory> findAllHistory(String username);

    void delete(PasswordHistory domain);
}
