package com.hwikun.bacs.admin.application.menu.repository;

import com.hwikun.bacs.admin.domain.Menu;

import java.util.List;
import java.util.Optional;

public interface MenuRepository {
    boolean existsMenu(Menu menu);

    Menu createMenu(Menu menu);

    Optional<Menu> findMenu(Menu menu);

    List<Menu> findAllMenu(String categoryId);

    void deleteMenu(Menu menu);

    Menu updateMenu(Menu menu);
}
