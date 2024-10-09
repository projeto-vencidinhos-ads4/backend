package com.application.vencidinhos.domain.service;

import com.application.vencidinhos.domain.dto.request.ProductRequestDto;
import com.application.vencidinhos.domain.dto.response.ProductDto;
import com.application.vencidinhos.domain.entity.Category;
import com.application.vencidinhos.domain.entity.Client;
import com.application.vencidinhos.domain.entity.Product;
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

    @Override
    public List<ProductDto> findProductsByClientId(Long clientId) {
        return this.productRepository.findAllByClientIdOrderByIdDesc(clientId)
                .stream()
                .map(ProductDto::new)
                .collect(Collectors.toList());
    }

    // PUT method implementation
    @Override
    public ProductDto changeProduct(Long id, ProductRequestDto productRequestDto) {
        // Fetching the existing Product by id
        Product existingProduct = productRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Product not found!"));

        // Fetching the Client entity based on the given "clientId"
        Client client = clientRepository.findById(existingProduct.getClient().getId()).orElseThrow(()
                -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Client not found!\n" +
                "The Client with id:" + existingProduct.getClient().getId() + "is non existent."));

        // Fetching the Category entity based on the given "categoryId"
        Category category = categoryRepository.findById(existingProduct.getCategory().getId()).orElseThrow(()
                -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Category not found!\n" +
                "The Category with id:" + existingProduct.getCategory().getId() + "is non existent."));

        // Updating the existingProduct with the productRequestDto data
        existingProduct.setName(productRequestDto.getName());
        existingProduct.setPrice(productRequestDto.getPrice());
        existingProduct.setQuantity(productRequestDto.getQuantity());
        existingProduct.setClient(client);
        existingProduct.setCategory(category);

        // Save the updated product
        this.productRepository.save(existingProduct);

        return new ProductDto(existingProduct);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + productId));

        productRepository.delete(product);
    }
}
