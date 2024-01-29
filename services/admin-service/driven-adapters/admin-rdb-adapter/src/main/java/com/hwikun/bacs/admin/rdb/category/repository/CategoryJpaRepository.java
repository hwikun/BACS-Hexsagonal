package com.hwikun.bacs.admin.rdb.category.repository;

import com.hwikun.bacs.admin.rdb.category.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, UUID> {
    Optional<CategoryEntity> findByStoreIdAndCategoryName(String storeId, String categoryName);
    boolean existsByStoreIdAndCategoryName(String storeId, String categoryName);

    List<CategoryEntity> findAllByStoreId(String storeId);
}
