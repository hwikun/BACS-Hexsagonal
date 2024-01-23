package com.hwikun.bacs.admin.domain;

import com.hwikun.bacs.admin.domain.types.StoreStatus;
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
public final class Store implements Serializable {
    @Getter
    private String id;
    public String username;
    public String storeName;
    public String address;
    public String storeDigit;
    public StoreStatus status;
}
