package com.application.vencidinhos.domain.service;

import com.application.vencidinhos.domain.dto.request.ClientRequestDto;
import com.application.vencidinhos.domain.dto.response.ClientResponseDto;
import com.application.vencidinhos.domain.entity.Client;
import com.application.vencidinhos.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImplement implements ClientServiceInterface {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImplement(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void createClient(ClientRequestDto clientRequestDto) {
        this.clientRepository.save(new Client(clientRequestDto));
    }

    @Override
    public ClientResponseDto updateClient(Long id, ClientRequestDto client) {

        Client existingClient = clientRepository.findById(id).orElseThrow();

        existingClient.setDocument(client.getDocument());
        existingClient.setName(client.getName());
        existingClient.setStore(client.getStore());
        existingClient.setType(client.getType());

        clientRepository.save(existingClient);

        ClientResponseDto clientResponseDto = new ClientResponseDto();

        clientResponseDto.setDocument(existingClient.getDocument());
        clientResponseDto.setName(existingClient.getName());
        clientResponseDto.setStore(existingClient.getStore());
        clientResponseDto.setType(existingClient.getType());

        return clientResponseDto;
    }

    @Override
    public void deleteClient(Long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new IllegalArgumentException("Client not found with id: " + clientId));

        clientRepository.delete(client);
    }


}
