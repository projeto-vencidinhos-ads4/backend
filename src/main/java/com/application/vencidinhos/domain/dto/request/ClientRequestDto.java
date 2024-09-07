package com.application.vencidinhos.domain.dto.request;

import com.application.vencidinhos.domain.entity.Category;
import com.application.vencidinhos.domain.entity.Client;
import com.application.vencidinhos.domain.entity.Product;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;

/**
 * DTO for {@link Client}
 */
@Data
public class ClientRequestDto {

    @NotBlank
    private String name;

    @NotBlank
    private String store;

    @NotBlank
    private String document;

    @NotBlank
    private String type;

}

