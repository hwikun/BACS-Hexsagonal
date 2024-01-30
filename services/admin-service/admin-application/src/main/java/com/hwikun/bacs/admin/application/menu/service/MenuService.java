package com.hwikun.bacs.admin.application.menu.service;

import com.hwikun.bacs.admin.application.category.repository.CategoryRepository;
import com.hwikun.bacs.admin.application.menu.repository.MenuRepository;
import com.hwikun.bacs.admin.application.menu.usecase.MenuUseCase;
import com.hwikun.bacs.admin.domain.Menu;
import com.hwikun.bacs.admin.exception.category.CategoryErrorCode;
import com.hwikun.bacs.admin.exception.menu.MenuErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuService implements MenuUseCase {
    private final MenuRepository menuRepository;
    private final CategoryRepository categoryRepository;
    @Override
    public Menu createMenu(Menu menu) {
        if (categoryRepository.existsCategoryById(menu.categoryId)) {
            throw CategoryErrorCode.CATEGORY_NULL.defaultException();
        }

        if (menuRepository.existsMenu(menu)) {
            throw MenuErrorCode.MENU_CONFLICT.defaultException();
        }

        return menuRepository.createMenu(menu);
    }

    @Override
    public Menu readMenu(Menu menu) {
        return menuRepository.findMenu(menu)
                .orElseThrow(MenuErrorCode.MENU_NULL::defaultException);
    }

    @Override
    public List<Menu> readMenuList(String categoryId) {
        if (categoryRepository.existsCategoryById(categoryId)) {
            throw CategoryErrorCode.CATEGORY_NULL.defaultException();
        }
        return menuRepository.findAllMenu(categoryId);
    }

    @Override
    public void deleteMenu(Menu menu) {
        if (menuRepository.existsMenu(menu)) {
            throw MenuErrorCode.MENU_NULL.defaultException();
        }
        menuRepository.deleteMenu(menu);
    }

    @Override
    public Menu updateMenu(Menu menu) {
        Menu target = menuRepository.findMenu(menu)
                .orElseThrow(MenuErrorCode.MENU_NULL::defaultException);

        if (menu.menuName != null) {
            target.menuName = menu.menuName;
        }
        if (menu.menuPrice != target.menuPrice) {
            target.menuPrice = menu.menuPrice;
        }
        if (menu.menuDesc != null) {
            target.menuDesc = menu.menuDesc;
        }
        if (menu.menuImg != null) {
            target.menuImg = menu.menuImg;
        }
        return menuRepository.updateMenu(target);
    }
}
