package com.application.vencidinhos.domain.service;

import org.springframework.stereotype.Service;

@Service
public interface CategoryServiceInterface {

    void deleteCategory(Long categoryId);
}
