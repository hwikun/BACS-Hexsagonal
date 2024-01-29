package com.hwikun.bacs.auth.rdb.account.entity;

import com.hwikun.bacs.auth.domain.types.AccountStatus;
import com.hwikun.bacs.core.jpa.support.UuidBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "account")
public class AccountEntity extends UuidBaseEntity {
    public String username;
    public String password;
    public String salt;

    @Enumerated(EnumType.STRING)
    public AccountStatus status;
}
