package com.servicecomm.customer.rest_template;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.jackson.autoconfigure.JacksonProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rest-template")
public class RestTemplateController {

    private final RestTemplateClient restTemplateClient;

    /**
     * Use RestTeplate to retrieve data from the provider microservice. Simplest way to retrieve data.
     * @return
     */
    @GetMapping("/customer/simple-instance")
    public String simpleInstance(){
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://localhost:8081/api/rest-template/provider/provider-info", String.class);
        return result;
    }

    /**
     * Use RestTemplateClient to retrieve the instance information from the provider microservice.
     * @return
     */
    @GetMapping("/customer/advance-instance")
    public String advanceInstance(){
        return restTemplateClient.getInstance();
    }

    /**
     * Retrieves a list of products from the API.
     * @return A list of products.
     */
    @GetMapping("/customer/products")
    public Object simpleProducts(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("""
                https://dummyjson.com/products""", Object.class);
    }
}
