package com.nttdata.bff_bank.expose;

import com.nttdata.bff_bank.feign.client.FeignClientApp;
import com.nttdata.bff_bank.microservice.api.ClientApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

public class ClientExpose implements ClientApi {

    @Autowired
    private FeignClientApp userFeignClientApp;


    @Override
    public Mono<ResponseEntity<Flux<Map<String, Object>>>> findAllClient(ServerWebExchange exchange) {

        Flux<Map<String, Object>> listado = userFeignClientApp.getAllClient();

        return Mono.just(ResponseEntity
                .status(HttpStatus.OK)
                .body(listado));

    }
}
