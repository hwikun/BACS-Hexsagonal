package com.hwikun.bacs.auth.domain;

import com.hwikun.bacs.auth.domain.types.AccountStatus;
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
public final class Account implements Serializable {
    @Getter
    private String id;
    public String username;
    public String password;
    public String salt;
    public AccountStatus status;
}