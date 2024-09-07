package com.application.vencidinhos.domain.dto.response;

import com.application.vencidinhos.domain.entity.Category;
import com.application.vencidinhos.domain.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * DTO for {@link Client}
 */

@NoArgsConstructor
@Data
public final class ClientDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 0L;
    private Long id;
    private String document;
    private String name;
    private String store;
    private String type;

    public ClientDto(Long id, String document, String name, String store, String type) {
        this.id = id;
        this.document = document;
        this.name = name;
        this.store = store;
        this.type = type;
    }

}
