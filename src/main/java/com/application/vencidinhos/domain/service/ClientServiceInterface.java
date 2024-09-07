package com.application.vencidinhos.domain.service;

import com.application.vencidinhos.domain.dto.request.ClientRequestDto;
import com.application.vencidinhos.domain.dto.response.ClientResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface ClientServiceInterface {

    void createClient(ClientRequestDto newClientDto);

    //ClientDto findClient(Long clientId);

    //List<ClientDto> findAll();

    ClientResponseDto updateClient(Long clientId, ClientRequestDto client);
}
