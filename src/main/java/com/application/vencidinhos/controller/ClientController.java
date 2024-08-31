package com.application.vencidinhos.controller;

import com.application.vencidinhos.domain.entity.Client;
import com.application.vencidinhos.infrastructure.IClientRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    IClientRepository clientRepository;

    public ClientController(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @PostMapping
    public Client save(){
        var cliente = this.clientRepository.save(new Client("teste","teste","teste", "teste"));
        return this.clientRepository.save(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        var usuario = this.clientRepository.findAll();

        return ResponseEntity.ok(usuario);
    }

}
