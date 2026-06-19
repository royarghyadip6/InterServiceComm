package com.servicecomm.customer.rest_client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class RestClientDataProvider {
    private final RestClient restClient;

    /**
     * Retrieves instance information from the provider service.
     * @return Provider instance information as a String
     */
    public String getInstance() {
        String providerUri = "/provider/provider-info";
        return restClient.get()
                .uri(providerUri)
                .retrieve()
                .body(String.class);
    }
}
