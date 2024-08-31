package com.application.vencidinhos.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="tb_client")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
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

    public Client(String document, String name, String store, String type) {
        this.document = document;
        this.name = name ;
        this.store = store;
        this.type = type;
    }
}
