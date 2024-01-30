package com.hwikun.bacs.admin.readmodels.menu;

import lombok.Builder;

public final class MenuReadModels {
    private MenuReadModels() {}

    @Builder
    public record MenuInfoReadModel(
            String id,
            String menuName,
            int menuPrice,
            String menuDesc,
            String menuImg
    ) {}
}
