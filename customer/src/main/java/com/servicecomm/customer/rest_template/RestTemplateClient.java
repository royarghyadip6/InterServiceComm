package com.servicecomm.customer.rest_template;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class RestTemplateClient {

    private final RestTemplate restTemplate;

    private final String providerUri = "http://localhost:8081/api/rest-template";

    public String getInstance(){
        return restTemplate.getForObject(providerUri + "/provider/provider-info", String.class);
    }
}
