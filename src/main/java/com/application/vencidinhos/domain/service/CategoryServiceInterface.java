package com.application.vencidinhos.domain.service;

import com.application.vencidinhos.domain.dto.request.CategoryRequestDto;
import com.application.vencidinhos.domain.dto.response.CategoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CategoryServiceInterface {

    ResponseEntity<CategoryDto> updateCategory(Long id, CategoryRequestDto categoryRequestDto);

    void deleteCategory(Long categoryId);

}
