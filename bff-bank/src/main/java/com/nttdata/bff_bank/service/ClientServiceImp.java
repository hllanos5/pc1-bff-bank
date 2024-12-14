package com.nttdata.bff_bank.service;

import com.nttdata.bff_bank.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImp implements  ClientService {

    @Value("${external.api.client}")
    private String endPointClient;

    @Override
    public Flux<ClientDTO> findAll() {

        WebClient webClient = WebClient.create(endPointClient);

        return webClient.get()
                .uri("/client")
                .retrieve()
                .bodyToFlux(ClientDTO.class);
    }
}
