package com.hwikun.bacs.admin.application.category.repository;

import com.hwikun.bacs.admin.domain.Category;
import com.hwikun.bacs.admin.domain.Store;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    Category createCategory(Category category);

    boolean existsCategory(Category category);
    boolean existsCategoryById(String id);

    Optional<Category> findCategory(Category category);

    Category updateCategory(Category category);

    void deleteCategory(Category category);

    List<Category> findCategoryList(String storeId);
}
