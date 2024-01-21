package com.hwikun.bacs.core.jpa.support;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.UUID;

@Getter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
// No EQUALS and HASHCODE required.
public abstract class UuidBaseEntity {
    // NOTE MySQL: binary(16)
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;
    @CreatedDate
    public Instant createdAt;
    @LastModifiedDate
    public Instant updatedAt;
}
