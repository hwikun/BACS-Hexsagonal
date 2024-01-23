package com.hwikun.bacs.auth.application.repository;

public interface RedisRepository {
    void save(String refreshToken, String username);
}
