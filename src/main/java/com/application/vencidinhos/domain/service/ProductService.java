package com.application.vencidinhos.domain.service;

import com.application.vencidinhos.domain.dto.request.ProductRequestDto;
import com.application.vencidinhos.domain.dto.response.ProductDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    void createProduct(ProductRequestDto newProductDto);

    ProductDto findProduct(Long productId);

    List<ProductDto> findAll();

    List<ProductDto> findProductsByClientId(Long clientId);

    ProductDto changeProduct(Long id, @Valid ProductRequestDto productRequestDto);

    void deleteProduct(Long productId);
}
