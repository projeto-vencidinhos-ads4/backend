package com.application.vencidinhos.domain.dto.response;

import lombok.Data;

@Data
public class ProductResponseDto {
    private Long productId;
    private String product;
    private String category;
    private Long quantity;
    private Double price;

}
