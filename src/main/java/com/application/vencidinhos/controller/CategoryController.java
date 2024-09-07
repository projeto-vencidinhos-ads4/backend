package com.application.vencidinhos.controller;

import com.application.vencidinhos.domain.dto.request.CategoryRequestDto;
import com.application.vencidinhos.domain.dto.response.CategoryDto;
import com.application.vencidinhos.domain.entity.Category;
import com.application.vencidinhos.domain.entity.Client;
import com.application.vencidinhos.domain.repository.CategoryRepository;
import com.application.vencidinhos.domain.repository.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    CategoryRepository categoryRepository;
    ClientRepository clientRepository;

    public CategoryController(CategoryRepository categoryRepository, ClientRepository clientRepository) {
        this.categoryRepository = categoryRepository;
        this.clientRepository = clientRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryDto> create(@RequestBody @Valid CategoryRequestDto categoryRequestDto) {
        Optional<Client> client = this.clientRepository.findById(categoryRequestDto.clientId());

        if (client.isEmpty()) return ResponseEntity.notFound().build();

        Category createdCategory =
                this.categoryRepository.save(new Category(categoryRequestDto, client.get()));

        return ResponseEntity.created(null).body(
                new CategoryDto(createdCategory));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll() {
        List<Category> listaCategorias = this.categoryRepository.findAll();

//        if (listaCategorias.isEmpty()) return ResponseEntity.noContent().build();


        return ResponseEntity.ok(listaCategorias
                .stream()
                .map(category -> {
                    if (category == null) return null;

                    return new CategoryDto(category);
                })
                .collect(Collectors.toList()));
    }
}
