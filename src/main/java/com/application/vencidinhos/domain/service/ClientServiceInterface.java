package com.application.vencidinhos.domain.service;

import com.application.vencidinhos.domain.dto.request.ClientRequestDto;
import com.application.vencidinhos.domain.dto.response.ClientResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface ClientServiceInterface {

    void createClient(ClientRequestDto newClientDto);

    ClientResponseDto updateClient(Long clientId, ClientRequestDto client);

    void deleteClient(Long clientId);
}


//ClientDto findClient(Long clientId);

//List<ClientDto> findAll();
