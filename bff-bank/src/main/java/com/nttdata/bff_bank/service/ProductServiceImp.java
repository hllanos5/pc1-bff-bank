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

    private final WebClient.Builder webClientBuilder;

    public ProductServiceImp(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public Mono<ProductDTO> findByClientId(String idClient) {

        return this.webClientBuilder
                .build()
                .get()
                .uri(endPointProduct.concat("/product/client-id/${id}"))
                .retrieve()
                .bodyToMono(ProductDTO.class);
    }

    @Override
    public Mono<ProductDTO> save(ProductDTO product) {

        return this.webClientBuilder
                .build()
                .post()
                .uri(endPointProduct.concat("/product"))
                .bodyValue(product)
                .retrieve()
                .bodyToMono(ProductDTO.class);

    }
}
