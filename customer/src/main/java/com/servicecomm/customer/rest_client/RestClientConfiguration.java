package com.servicecomm.customer.rest_client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfiguration {

    /**
     * RestClient bean configured with the provider base URL (/api/rest-client).
     * Exposed as a Spring @Bean for injection where HTTP calls to the provider
     * are required. Adjust the base URL here or via configuration per environment.
     */
    @Bean
    public RestClient restClient() {
        RestClient restClient = RestClient.builder()
                .baseUrl("http://localhost:8081/api/rest-template")
                .build();
        return restClient;
    }
}
