package com.servicecomm.customer.web_client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WebClientDataProvider {
    private final WebClient webClient;

    public Mono<String> getProviderInfo() {
        return webClient.get()
                .uri("/api/rest-template/provider/provider-info")
                .retrieve()
                .bodyToMono(String.class);
//                .block(); // block() converts reactive call to a synchronous one (returns string);
    }
}
