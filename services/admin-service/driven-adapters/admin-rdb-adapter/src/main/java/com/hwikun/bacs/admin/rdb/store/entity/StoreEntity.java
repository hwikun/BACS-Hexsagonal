package com.hwikun.bacs.admin.rdb.store.entity;

import com.hwikun.bacs.admin.domain.types.StoreStatus;
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
@DynamicUpdate
@Table(name = "store")
public class StoreEntity extends UuidBaseEntity {
    public String username;
    public String storeName;
    public String address;
    public String storeDigit;

    @Enumerated(EnumType.STRING)
    public StoreStatus status;
}
