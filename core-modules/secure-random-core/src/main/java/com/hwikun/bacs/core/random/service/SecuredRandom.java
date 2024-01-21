package com.hwikun.bacs.core.random.service;

public interface SecuredRandom {
    String generate(int length, boolean isEncode);
}
