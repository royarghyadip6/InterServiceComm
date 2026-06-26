package com.servicecomm.customer.open_feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Feign client for calling the provider service.
 *
 * Note: You do not annotate a Feign client with @LoadBalanced. When using
 * Spring Cloud and service discovery (Eureka) or Spring Cloud LoadBalancer,
 * Feign resolves the logical service name (the value of {@code name}) and
 * will perform client-side load balancing for you. If you need a
 * LoadBalanced RestTemplate, annotate the RestTemplate bean with
 * {@code @LoadBalanced} instead.
 */
//@FeignClient(name = "provider-service", url = "http://localhost:8081")
@FeignClient(name = "provider")
public interface OpenFeignClient {

    @GetMapping("/api/rest-template/provider/provider-info")
    String getInstance();
}
