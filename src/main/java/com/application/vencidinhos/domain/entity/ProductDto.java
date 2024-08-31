package com.application.vencidinhos.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * DTO for {@link Product}
 */
public record ProductDto(Long id,
                         String name,
                         CategoryDto category,
                         BigDecimal price,
                         Integer quantity,
                         Date expirationDate,
                         ClientDto client) implements Serializable {
}