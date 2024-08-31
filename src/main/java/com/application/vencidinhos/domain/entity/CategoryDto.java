package com.application.vencidinhos.domain.entity;

import java.io.Serializable;

/**
 * DTO for {@link Category}
 */
public record CategoryDto(Long id, String name) implements Serializable {
}