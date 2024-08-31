package com.application.vencidinhos.controller;

import com.application.vencidinhos.domain.entity.Category;
import com.application.vencidinhos.domain.entity.Client;
import com.application.vencidinhos.domain.entity.Product;
import com.application.vencidinhos.infrastructure.ICategoryRepository;
import com.application.vencidinhos.infrastructure.IClientRepository;
import com.application.vencidinhos.infrastructure.IProductRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    IProductRepository productRepository;
    ICategoryRepository categoryRepository;
    IClientRepository clientRepository;

    public ProductController(IProductRepository productRepository, ICategoryRepository categoryRepository, IClientRepository clientRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.clientRepository = clientRepository;
    }

    @PostMapping
    public Product save() {

        var cliente = this.clientRepository.save(new Client("teste", "teste", "teste", "teste"));
        var categoria = this.categoryRepository.save(new Category("Secos"));

        var produto = new Product(null, "Pão", 10.9, 29, cliente, categoria);
        System.out.println(produto);


        return this.productRepository.save(produto);
    }
}
