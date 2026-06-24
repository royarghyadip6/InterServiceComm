package com.servicecomm.customer.open_feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name = "provider-service", url = "http://localhost:8081")
@FeignClient(name = "provider")
public interface OpenFeignClient {

    @GetMapping("/api/rest-template/provider/provider-info")
    String getInstance();
}
