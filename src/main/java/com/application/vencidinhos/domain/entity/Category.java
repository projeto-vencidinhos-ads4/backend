package com.application.vencidinhos.domain.entity;

import com.application.vencidinhos.domain.dto.request.CategoryRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="tb_category")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    public Category(String name) {
        this.name = name;
    }

    public Category(CategoryRequestDto categoryRequestDto, Client client) {
        this.name = categoryRequestDto.name();
        this.client = client;
    }
}
