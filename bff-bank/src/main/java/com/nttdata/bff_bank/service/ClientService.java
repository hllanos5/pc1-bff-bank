package com.nttdata.bff_bank.service;

import com.nttdata.bff_bank.dto.ClientDTO;
import reactor.core.publisher.Flux;

public interface ClientService {

    Flux<ClientDTO> findAll();
}
