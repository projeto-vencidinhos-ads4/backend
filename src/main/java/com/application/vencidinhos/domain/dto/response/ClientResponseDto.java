package com.application.vencidinhos.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponseDto {
    private Long id;
    private String document;
    private String name;
    private String store;
    private String type;

}
