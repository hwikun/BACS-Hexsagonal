package com.hwikun.bacs.admin.application.category.usecase;

import com.hwikun.bacs.admin.domain.Category;
import com.hwikun.bacs.admin.domain.Store;

import java.util.List;

public interface CategoryUseCase {
    Category createCategory(String username, Category category);
    Category readCategory(String username, Category category);
    Category updateCategory(String username, Category category, String newCategoryName);
    void deleteCategory(String username, Category category);
    List<Category> readCategoryList(String username);

}
