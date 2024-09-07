package com.application.vencidinhos.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tb_products")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Product {

    public Product(String name, Double price, Integer quantity, Client client, Category category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.client = client;
        this.category = category;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}
