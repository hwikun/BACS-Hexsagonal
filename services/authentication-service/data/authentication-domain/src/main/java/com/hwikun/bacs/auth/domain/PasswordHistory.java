package com.hwikun.bacs.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public final class PasswordHistory implements Serializable {
    @Getter
    private String id;
    public String username;
    public String password;
}
