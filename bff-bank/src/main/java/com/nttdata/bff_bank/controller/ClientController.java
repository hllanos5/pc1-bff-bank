package com.nttdata.bff_bank.controller;

import com.nttdata.bff_bank.microservice.api.ClientApi;
import com.nttdata.bff_bank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@RestController
public class ClientController implements ClientApi {

    @Autowired
    private ClientService clientService;

    @Override
    public Mono<ResponseEntity<Flux<Map<String, Object>>>> findAllClient(ServerWebExchange exchange) {

        return Mono.just(ResponseEntity
                .status(HttpStatus.OK)
                .body(clientService.findAll().map(client -> {
                    Map<String, Object> clientMap = new HashMap<>();
                    clientMap.put("id", client.getId());
                    clientMap.put("dni", client.getDni());
                    clientMap.put("names", client.getNames());
                    clientMap.put("surnames", client.getSurnames());
                    clientMap.put("email", client.getEmail());
                    clientMap.put("phone", client.getPhone());
                    clientMap.put("type", client.getType());
                    return clientMap;
                })));

    }
}
