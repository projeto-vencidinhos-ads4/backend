package com.application.vencidinhos.domain.dto.response;

import com.application.vencidinhos.domain.entity.Client;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link Client}
 */
@Data
public class ClientResponseInfoDto implements Serializable {
    Long id;
    String document;
    String name;
    String store;
    String type;

    public ClientResponseInfoDto(Client client) {
        this.id = client.getId();
        this.document = client.getDocument();
        this.name = client.getName();
        this.store = client.getStore();
        this.type = client.getType();
    }
}