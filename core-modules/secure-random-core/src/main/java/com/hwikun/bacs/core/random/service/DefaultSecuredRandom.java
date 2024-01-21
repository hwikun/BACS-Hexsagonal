package com.hwikun.bacs.core.random.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Base64.Encoder;

@Component
@RequiredArgsConstructor
public final class DefaultSecuredRandom implements SecuredRandom {
    private final Encoder encoder = Base64.getEncoder();
    private final SecureRandom secureRandom;


    private final static char[] charSet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

    @Override
    public String generate(int length, boolean isEncode) {
        StringBuilder builder = new StringBuilder(length); // TODO check trigger to increase capacity

        for (int i  = 0; i < length; i++) {
            builder.append(charSet[secureRandom.nextInt(charSet.length)]);
        }

        String randomString = builder.toString();

        if (isEncode) {
            return encoder.encodeToString(randomString.getBytes());
        } else {
            return randomString;
        }
    }
}