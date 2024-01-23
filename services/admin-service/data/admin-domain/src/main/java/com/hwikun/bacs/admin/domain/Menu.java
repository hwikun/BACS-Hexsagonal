package com.hwikun.bacs.admin.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public final class Menu implements Serializable {
    @Getter
    private String id;
    public String storeId;
    public String categoryId;
    public String menuName;
    public int menuPrice;
    public String menuDesc;
    public String menuImg;
}
