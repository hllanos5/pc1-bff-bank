package com.nttdata.bff_bank.controller;

import com.nttdata.bff_bank.dto.ProductDTO;
import com.nttdata.bff_bank.microservice.api.AccountApi;
import com.nttdata.bff_bank.microservice.api.ClientApi;
import com.nttdata.bff_bank.model.Account;
import com.nttdata.bff_bank.service.ClientService;
import com.nttdata.bff_bank.service.ProductService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AccountController implements AccountApi {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;

    @Override
    public Mono<ResponseEntity<Map<String, Object>>> createProduct(Mono<Account> account, ServerWebExchange exchange) {

        return account.map(acc -> {
            ProductDTO product = new ProductDTO();

            product.setCreatedAt(new Date());
            product.setClientId(acc.getClientId());
            product.setType(acc.getProductType());
            product.setAccountType(acc.getAccountType());
            product.setActiveType(acc.getActiveType());
            product.setAccountNumber(acc.getAccountNumber());
            product.setAmount(acc.getAmount());

            productService.findByClientId(acc.getClientId())
                    .switchIfEmpty(
                            productService.save(product)
                    );
            // Devolvemos el ResponseEntity con el Map como cuerpo
            return ResponseEntity.ok(null);
        });

    }
}
