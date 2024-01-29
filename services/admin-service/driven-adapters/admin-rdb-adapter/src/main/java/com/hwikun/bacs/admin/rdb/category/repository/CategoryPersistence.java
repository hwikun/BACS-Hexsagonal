package com.hwikun.bacs.admin.rdb.category.repository;

import com.hwikun.bacs.admin.application.category.repository.CategoryRepository;
import com.hwikun.bacs.admin.domain.Category;
import com.hwikun.bacs.admin.exception.category.CategoryErrorCode;
import com.hwikun.bacs.admin.rdb.category.entity.CategoryEntity;
import com.hwikun.bacs.admin.rdb.category.mapper.CategoryEntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Slf4j
@Transactional
public class CategoryPersistence implements CategoryRepository {
    private final CategoryEntityMapper mapper;
    private final CategoryJpaRepository categoryJpaRepository;
    @Override
    public Category createCategory(Category category) {
        CategoryEntity entity = categoryJpaRepository.save(mapper.toEntity(category));
        return mapper.toDomain(entity);
    }

    @Override
    public boolean existsCategory(Category category) {
        return categoryJpaRepository.existsByStoreIdAndCategoryName(category.storeId, category.categoryName);
    }

    @Override
    public boolean existsCategoryById(String id) {
        return categoryJpaRepository.existsById(UUID.fromString(id));
    }

    @Override
    public Optional<Category> findCategory(Category category) {
        return categoryJpaRepository.findByStoreIdAndCategoryName(category.storeId, category.categoryName)
                .map(mapper::toDomain);
    }

    @Override
    public Category updateCategory(Category category) {
        CategoryEntity entity = categoryJpaRepository
                .findById(mapper.toEntity(category).getId())
                .orElseThrow(CategoryErrorCode.CATEGORY_NULL::defaultException);
        entity.categoryName = category.categoryName;
        return mapper.toDomain(entity);
    }

    @Override
    public void deleteCategory(Category category) {
        CategoryEntity entity = mapper.toEntity(category);
        categoryJpaRepository.delete(entity);
    }

    @Override
    public List<Category> findCategoryList(String storeId) {
        List<CategoryEntity> entityList = categoryJpaRepository.findAllByStoreId(storeId);
        return mapper.toDomain(entityList);
    }
}
