package com.application.vencidinhos.domain.dto.response;

import com.application.vencidinhos.domain.entity.Product;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * DTO for {@link Product}
 */
@Data
public final class ProductDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 0L;
    private final Long id;
    private final String name;
    private final Double price;
    private final Integer quantity;
    private final Long clientId;
    private final String clientDocument;
    private final String clientName;
    private final String clientStore;
    private final String clientType;
    private final Long categoryId;
    private final String categoryName;

    public ProductDto(Product product
    ) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
        this.clientId = product.getClient().getId();
        this.clientDocument = product.getClient().getDocument();
        this.clientName = product.getClient().getName();
        this.clientStore = product.getClient().getStore();
        this.clientType = product.getClient().getType();
        this.categoryId = product.getCategory().getId();
        this.categoryName = product.getCategory().getName();
    }
}