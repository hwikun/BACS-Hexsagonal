package com.hwikun.bacs.admin.application.menu.usecase;

import com.hwikun.bacs.admin.domain.Menu;
import com.hwikun.bacs.admin.readmodels.menu.MenuReadModels.MenuInfoReadModel;

import java.util.List;

public interface MenuUseCase {
    Menu createMenu(Menu menu);
    Menu readMenu(Menu menu);
    void deleteMenu(Menu menu);
    Menu updateMenu(Menu menu);
    List<Menu> readMenuList(String categoryId);
}
