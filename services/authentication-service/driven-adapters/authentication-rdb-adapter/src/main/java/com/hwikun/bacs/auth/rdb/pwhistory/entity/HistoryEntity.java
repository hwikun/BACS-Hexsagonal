package com.hwikun.bacs.auth.rdb.pwhistory.entity;

import com.hwikun.bacs.core.jpa.support.UuidBaseEntity;
import jakarta.persistence.Entity;
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
@Table(name = "password_history")
public final class HistoryEntity extends UuidBaseEntity {
    public String username;
    public String password;
}
