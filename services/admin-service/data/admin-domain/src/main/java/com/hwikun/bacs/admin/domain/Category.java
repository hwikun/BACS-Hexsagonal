package com.hwikun.bacs.admin.domain;

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
public final class Category implements Serializable {
    @Getter
    private String id;
    public String storeId;
    public String categoryName;
}
