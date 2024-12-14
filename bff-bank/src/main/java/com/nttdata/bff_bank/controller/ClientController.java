package com.nttdata.bff_bank.controller;

import com.nttdata.bff_bank.microservice.api.ClientApi;
import com.nttdata.bff_bank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
public class ClientController implements ClientApi {

    @Autowired
    private ClientService clientService;

    @Override
    public Mono<ResponseEntity<Flux<Map<String, Object>>>> findAllClient(ServerWebExchange exchange) {
        clientService.findAll();

        return Mono.just(ResponseEntity
                .status(HttpStatus.OK)
                .body(null));

    }
}
