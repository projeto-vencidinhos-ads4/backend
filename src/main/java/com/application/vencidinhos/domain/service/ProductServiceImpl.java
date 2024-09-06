package com.application.vencidinhos.domain.service;

import com.application.vencidinhos.domain.dto.request.ProductRequestDto;
import com.application.vencidinhos.domain.dto.response.ProductDto;
import com.application.vencidinhos.domain.entity.Category;
import com.application.vencidinhos.domain.entity.Client;
import com.application.vencidinhos.domain.repository.CategoryRepository;
import com.application.vencidinhos.domain.repository.ClientRepository;
import com.application.vencidinhos.domain.repository.ProductRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ClientRepository clientRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, ClientRepository clientRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.clientRepository = clientRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void createProduct(ProductRequestDto newProductDto) {
        Client client = this.clientRepository.findById(newProductDto.getClientId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Client not found"));

        Category category = this.categoryRepository.findById(newProductDto.getCategoryId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Category not found"));

        this.productRepository.save(newProductDto.toProduct(client, category));

    }

    @Override
    public ProductDto findProduct(Long productId) {
        return this.productRepository.findById(productId)
                .map(ProductDto::new)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Product not found!"));
    }

    @Override
    public List<ProductDto> findAll() {
        return this.productRepository.findAll()
                .stream()
                .map(ProductDto::new)
                .collect(Collectors.toList());
    }
}
