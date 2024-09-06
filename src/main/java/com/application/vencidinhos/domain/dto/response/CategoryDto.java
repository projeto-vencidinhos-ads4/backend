package com.application.vencidinhos.domain.dto.response;

import com.application.vencidinhos.domain.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link Category}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public final class CategoryDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 0L;
    private Long id;
    private String name;
    private Long clientId;

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.clientId = category.getClient().getId();
    }
}