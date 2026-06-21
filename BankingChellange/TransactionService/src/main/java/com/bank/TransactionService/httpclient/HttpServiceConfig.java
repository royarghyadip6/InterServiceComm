package com.bank.TransactionService.httpclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpServiceConfig {

    @Bean
    public I_HttpServiceClient httpServiceClient() {
        WebClient webClient = WebClient.builder().baseUrl("http://localhost:8083").build();
        WebClientAdapter adapter = WebClientAdapter.create(webClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        I_HttpServiceClient service = factory.createClient(I_HttpServiceClient.class);
// Use service methods for remote calls...
        return service;
    }
}
