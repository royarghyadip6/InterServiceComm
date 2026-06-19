package com.servicecomm.customer.open_feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "provider-service", url = "http://localhost:8081/api/rest-template")
public interface OpenFeignClient {

    @GetMapping("/provider/provider-info")
    String getInstance();
}
