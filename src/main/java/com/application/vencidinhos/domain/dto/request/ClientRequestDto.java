package com.application.vencidinhos.domain.dto.request;

import com.application.vencidinhos.domain.entity.Product;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;

/**
 * DTO for {@link com.application.vencidinhos.domain.entity.Client}
 */
public record ClientRequestDto(
        @NotBlank String document,
        @NotBlank String name,
        @NotBlank String store,
        @NotBlank String type) implements Serializable {
}