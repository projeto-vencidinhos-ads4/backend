package com.application.vencidinhos.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="tb_clients")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "document", nullable = false)
    private String document;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "store", nullable = false)
    private String store;

    @Column(name = "type", nullable = false)
    private String type;

    @OneToMany(mappedBy = "client")
    private List<Product> products;

}
