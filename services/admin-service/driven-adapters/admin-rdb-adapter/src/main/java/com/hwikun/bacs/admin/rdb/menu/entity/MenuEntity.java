package com.hwikun.bacs.admin.rdb.menu.entity;

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
@Table(name = "menu")
public class MenuEntity extends UuidBaseEntity {
    public String categoryId;
    public String menuName;
    public int    menuPrice;
    public String menuDesc;
    public String menuImg;
}
