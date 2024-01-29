package com.hwikun.bacs.admin.rdb.category.entity;

import com.hwikun.bacs.core.jpa.support.UuidBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "category")
public final class CategoryEntity extends UuidBaseEntity {
    public String storeId;
    public String categoryName;
}
