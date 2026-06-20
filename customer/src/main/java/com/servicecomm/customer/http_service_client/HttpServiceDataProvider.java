package com.servicecomm.customer.http_service_client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpServiceDataProvider {

    @Bean
    public I_HttpServiceInterface httpWebClientServiceInterface() {
        WebClient webClient = WebClient.create("http://localhost:8081");
        WebClientAdapter adapter = WebClientAdapter.create(webClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        I_HttpServiceInterface service = factory.createClient(I_HttpServiceInterface.class);
// Use service methods for remote calls...
        return  service;
    }
}
