package com.hwikun.bacs.admin.rdb.menu.repository;

import com.hwikun.bacs.admin.application.menu.repository.MenuRepository;
import com.hwikun.bacs.admin.domain.Menu;
import com.hwikun.bacs.admin.exception.menu.MenuErrorCode;
import com.hwikun.bacs.admin.rdb.menu.entity.MenuEntity;
import com.hwikun.bacs.admin.rdb.menu.mapper.MenuEntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
@Transactional
public class MenuPersistence implements MenuRepository {
    private final MenuJpaRepository menuJpaRepository;
    private final MenuEntityMapper mapper;
    @Override
    public boolean existsMenu(Menu menu) {
        return menuJpaRepository.existsByCategoryIdAndMenuName(menu.categoryId, menu.menuName);
    }

    @Override
    public Menu createMenu(Menu menu) {
        MenuEntity entity = menuJpaRepository.save(mapper.toEntity(menu));
        return mapper.toDomain(entity);
    }

    @Override
    public Optional<Menu> findMenu(Menu menu) {
        return menuJpaRepository.findByCategoryIdAndMenuName(menu.categoryId, menu.menuName)
                .map(mapper::toDomain);
    }

    @Override
    public List<Menu> findAllMenu(String categoryId) {
        List<MenuEntity> entityList = menuJpaRepository.findAllByCategoryId(categoryId);
        return mapper.toDomain(entityList);
    }

    @Override
    public void deleteMenu(Menu menu) {
        MenuEntity entity = mapper.toEntity(menu);
        menuJpaRepository.delete(entity);
    }

    @Override
    public Menu updateMenu(Menu menu) {
        MenuEntity entity = menuJpaRepository.findByCategoryIdAndMenuName(menu.categoryId, menu.menuName)
                .orElseThrow(MenuErrorCode.MENU_NULL::defaultException);

        if (menu.menuName != null) {
            entity.menuName = menu.menuName;
        }
        if (menu.menuPrice != entity.menuPrice) {
            entity.menuPrice = menu.menuPrice;
        }
        if (menu.menuDesc != null) {
            entity.menuDesc = menu.menuDesc;
        }
        if (menu.menuImg != null) {
            entity.menuImg = menu.menuImg;
        }
        return mapper.toDomain(entity);


    }
}
