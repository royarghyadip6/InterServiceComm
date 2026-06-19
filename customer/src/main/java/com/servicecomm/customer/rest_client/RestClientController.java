package com.servicecomm.customer.rest_client;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rest-client")
public class RestClientController {

    private final RestClientDataProvider restClientDataProvider;

    /**
     * Simplest way of using RestClient
     * Performs inter-service communication using Spring's RestClient to fetch provider information.
     * Creates a RestClient instance and sends a GET request to the provider service endpoint.
     * Retrieves and returns the response body as a String from the provider service.
     * @return Provider response data containing instance and service information
     */
    @GetMapping("/simple-provider-info")
    public String getSimpleProviderInfo() {
        RestClient restClient = RestClient.create();

        return restClient.get()
                .uri("""
                        http://localhost:8081/api/rest-template/provider/provider-info""")
                .retrieve()
                .body(String.class);
    }

    @GetMapping("/advance-provider-info")
    public String getAdvanceProviderInfo() {
        return restClientDataProvider.getInstance();
    }
}
