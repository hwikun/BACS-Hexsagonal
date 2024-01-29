package com.hwikun.bacs.admin.application.category.service;

import com.hwikun.bacs.admin.application.category.repository.CategoryRepository;
import com.hwikun.bacs.admin.application.category.usecase.CategoryUseCase;
import com.hwikun.bacs.admin.application.store.repository.StoreRepository;
import com.hwikun.bacs.admin.domain.Category;
import com.hwikun.bacs.admin.domain.Store;
import com.hwikun.bacs.admin.exception.category.CategoryErrorCode;
import com.hwikun.bacs.admin.exception.store.StoreErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService implements CategoryUseCase {
    private final CategoryRepository categoryRepository;
    private final StoreRepository storeRepository;

    @Override
    public Category createCategory(String username, Category category) {
        Store store = storeRepository.findStoreByUsername(username)
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);
        category.storeId = store.getId();
        if (categoryRepository.existsCategory(category)) {
            throw CategoryErrorCode.CATEGORY_CONFLICT.defaultException();
        }
        return categoryRepository.createCategory(category);
    }

    @Override
    public Category readCategory(String username, Category category) {
        Store store = storeRepository.findStoreByUsername(username)
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);
        category.storeId = store.getId();

        return categoryRepository.findCategory(category)
                .orElseThrow(CategoryErrorCode.CATEGORY_NULL::defaultException);
    }

    @Override
    public Category updateCategory(String username, Category category, String newCategoryName) {
        Store store = storeRepository.findStoreByUsername(username)
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);

        category.storeId = store.getId();

        Category target = categoryRepository.findCategory(category)
                .orElseThrow(CategoryErrorCode.CATEGORY_NULL::defaultException);

        target.categoryName = newCategoryName;

        return categoryRepository.updateCategory(target);
    }

    @Override
    public void deleteCategory(String username, Category category) {
        Store store = storeRepository.findStoreByUsername(username)
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);

        category.storeId = store.getId();

        Category target = categoryRepository.findCategory(category)
                .orElseThrow(CategoryErrorCode.CATEGORY_NULL::defaultException);

        categoryRepository.deleteCategory(target);
    }

    @Override
    public List<Category> readCategoryList(String username) {
        Store store = storeRepository.findStoreByUsername(username)
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);

        return categoryRepository.findCategoryList(store.getId());
    }
}
