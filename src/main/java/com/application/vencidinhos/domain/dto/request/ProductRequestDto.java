package com.application.vencidinhos.domain.dto.request;

import com.application.vencidinhos.domain.entity.Category;
import com.application.vencidinhos.domain.entity.Client;
import com.application.vencidinhos.domain.entity.Product;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * DTO for {@link com.application.vencidinhos.domain.entity.Product}
 */
@Data
public class ProductRequestDto {
    @NotBlank
    String name;

    @DecimalMin("0.0")
    Double price;

    @Min(10)
    Integer quantity;

    @NotNull
    Long clientId;

    @NotNull
    Long categoryId;

    public Product toProduct(Client client, Category category){
        return new Product(this.getName(), this.getPrice(), this.getQuantity(), client, category);
    }
}