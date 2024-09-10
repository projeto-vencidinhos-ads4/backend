package com.application.vencidinhos.controller;

import com.application.vencidinhos.domain.dto.request.ProductRequestDto;
import com.application.vencidinhos.domain.dto.response.ProductDto;
import com.application.vencidinhos.domain.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> save(@RequestBody @Valid ProductRequestDto productRequestDto) {
        this.productService.createProduct(productRequestDto);

        return ResponseEntity.created(URI.create("")).build();
    }

    @GetMapping("/item/{productId}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable Long productId){
        return ResponseEntity.status(200).body(this.productService.findProduct(productId));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll(){
        return ResponseEntity.ok(this.productService.findAll());
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<?> findProductsByClientId(@PathVariable Long clientId){
        return ResponseEntity.ok(this.productService.findProductsByClientId(clientId));
    }


}
