package com.hwikun.bacs.admin.rdb.option.entity;

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
@Table(name = "option")
public class OptionEntity extends UuidBaseEntity {
    public String menuId;
    public String optionName;
    public String optionValue;
    public int    optionPrice;
    public String optionDesc;
}
