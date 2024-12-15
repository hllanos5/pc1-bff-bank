package com.nttdata.bff_bank.service;

import com.nttdata.bff_bank.dto.ClientDTO;
import com.nttdata.bff_bank.dto.ProductDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

    Mono<ProductDTO> findByClientId(String idClient);
    Mono<ProductDTO> save(ProductDTO product);
}
