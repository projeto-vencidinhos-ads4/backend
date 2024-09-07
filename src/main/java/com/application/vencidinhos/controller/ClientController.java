package com.application.vencidinhos.controller;

import com.application.vencidinhos.domain.dto.request.ClientRequestDto;
import com.application.vencidinhos.domain.dto.response.ClientResponseInfoDto;
import com.application.vencidinhos.domain.entity.Client;
import com.application.vencidinhos.infrastructure.IClientRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/clients")
public class ClientController {

    IClientRepository clientRepository;

    public ClientController(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @PostMapping
    public Client save(@RequestBody @Valid ClientRequestDto client) {
        var cliente = this.clientRepository.save(new Client(client));
        return this.clientRepository.save(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        var usuario = this.clientRepository.findAll();

        return ResponseEntity.ok(usuario);
    }

    @GetMapping("{id}")
    public ResponseEntity<List<ClientResponseInfoDto>> findById(@PathVariable Long id){
        var client = this.clientRepository.findAllById(Collections.singleton(id))
                .stream()
                .map(ClientResponseInfoDto::new)
                .collect(Collectors.toList());
        if (client.isEmpty()) ResponseEntity.noContent().build();

        return ResponseEntity.ok(client);
    }

}
