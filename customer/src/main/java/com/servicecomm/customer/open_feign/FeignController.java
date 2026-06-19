package com.servicecomm.customer.open_feign;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/open-feign")
public class FeignController {
    private final OpenFeignClient openFeignClient;

    /**
     * OpenFeign is used to communicate with microservices. If new API need to be accessed from provider microservice, just add a new method in OpenFeignClient interface and call it here.
     * OpenFeign splits the communication layer cleanly between an Interface (which defines how to talk to the remote service) and a Controller (which handles incoming requests and consumes that interface).
     * @return
     */
    @RequestMapping("/provider-info")
    public String getProviderInfo() {
        return openFeignClient.getInstance();
    }
}
