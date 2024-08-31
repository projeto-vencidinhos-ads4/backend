package com.application.vencidinhos.domain.entity;

import java.io.Serializable;

/**
 * DTO for {@link Client}
 */
public record ClientDto(Long id, String document, String name, String store, String type) implements Serializable {
}