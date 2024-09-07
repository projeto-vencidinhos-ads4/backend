package com.application.vencidinhos.domain.entity;

import com.application.vencidinhos.domain.dto.request.ClientRequestDto;
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

    @OneToMany(mappedBy = "client")
    private List<Category> categories;

    public Client(ClientRequestDto client) {
        this.document = client.getDocument();
        this.name = client.getName() ;
        this.store = client.getStore();
        this.type = client.getType();
    }
}
