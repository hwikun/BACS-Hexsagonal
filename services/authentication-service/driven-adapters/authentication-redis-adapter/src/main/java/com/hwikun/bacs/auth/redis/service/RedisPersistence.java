package com.hwikun.bacs.auth.redis.service;

import com.hwikun.bacs.auth.application.repository.RedisRepository;
import com.hwikun.bacs.auth.redis.entity.UserRefreshToken;
import com.hwikun.bacs.auth.redis.repository.UserRefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RedisPersistence implements RedisRepository {
    private final UserRefreshTokenRepository redisRepository;

    @Override
    public void save(String refreshToken, String username) {
        UserRefreshToken token = UserRefreshToken.builder()
                .refreshToken(refreshToken)
                .username(username)
                .ttl(2_592_000)
                .build();
        redisRepository.save(token);
    }
}
