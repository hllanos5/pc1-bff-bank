package com.nttdata.bff_bank.service;

import com.nttdata.bff_bank.dto.ClientDTO;
import com.nttdata.bff_bank.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImp implements  ProductService {

    @Value("${external.api.product}")
    private String endPointProduct;

    @Override
    public Mono<ProductDTO> findByClientId(String idClient) {

        WebClient webClient = WebClient.create(endPointProduct);

        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/product/client-id/${id}").build(idClient))
                .retrieve()
                .bodyToMono(ProductDTO.class);
    }

    @Override
    public Mono<ProductDTO> save(ProductDTO product) {
        WebClient webClient = WebClient.create(endPointProduct);

        return webClient.post()
                .uri("/product")
                .bodyValue(product)
                .retrieve()
                .bodyToMono(ProductDTO.class);

    }
}
