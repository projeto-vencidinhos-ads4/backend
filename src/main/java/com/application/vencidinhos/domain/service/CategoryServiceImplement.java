package com.application.vencidinhos.domain.service;

import com.application.vencidinhos.domain.entity.Category;
import com.application.vencidinhos.domain.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImplement implements CategoryServiceInterface {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImplement(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + categoryId));

        categoryRepository.delete(category);
    }
}
