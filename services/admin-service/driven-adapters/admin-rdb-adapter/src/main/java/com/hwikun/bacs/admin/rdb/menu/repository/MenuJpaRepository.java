package com.hwikun.bacs.admin.rdb.menu.repository;

import com.hwikun.bacs.admin.rdb.menu.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MenuJpaRepository extends JpaRepository<MenuEntity, UUID> {
    boolean existsByCategoryIdAndMenuName(String categoryId, String menuName);
    Optional<MenuEntity> findByCategoryIdAndMenuName(String categoryId, String menuName);
    List<MenuEntity> findAllByCategoryId(String categoryId);
}
