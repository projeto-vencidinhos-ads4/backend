package com.application.vencidinhos.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link com.application.vencidinhos.domain.entity.Category}
 */
public record CategoryRequestDto(@NotBlank String name, Long clientId) implements Serializable {
}