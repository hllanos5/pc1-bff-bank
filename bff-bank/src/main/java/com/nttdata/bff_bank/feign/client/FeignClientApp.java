package com.nttdata.bff_bank.feign.client;

import com.nttdata.bff_bank.feign.configuration.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;

import java.util.Map;

@FeignClient(
        name = "API",
        url = "${external.api.client}",
        configuration = FeignClientConfig.class)
public interface  FeignClientApp {
    @GetMapping("/client")
    Flux<Map<String, Object>> getAllClient();

}
