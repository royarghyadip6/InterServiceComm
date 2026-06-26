package com.servicecomm.customer.rest_template;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    /**
     * Creates a load-balanced RestTemplate bean.
     *
     * <b>Why @LoadBalanced is Required:</b>
     * The @LoadBalanced annotation enables client-side load balancing for the RestTemplate.
     * It intercepts RestTemplate calls and distributes requests across multiple service instances
     * registered with the service discovery server (Eureka).
     *
     * <b>How @LoadBalanced Helps:</b>
     * 1. <b>Service Discovery Integration:</b> Automatically resolves service names to actual IP addresses
     *    using Eureka (or other service discovery mechanisms), eliminating the need for hardcoded URLs.
     *
     * 2. <b>Client-Side Load Balancing:</b> When multiple instances of a service are available,
     *    @LoadBalanced distributes incoming requests across these instances (using round-robin by default),
     *    improving overall system throughput and preventing any single instance from being overwhelmed.
     *
     * 3. <b>Fault Tolerance:</b> If one service instance fails, requests are automatically routed to
     *    healthy instances, improving application resilience and availability.
     *
     * 4. <b>Dynamic Scaling:</b> As new service instances are registered with Eureka, they are automatically
     *    discovered and added to the load balancing pool without requiring manual configuration changes.
     *
     * 5. <b>Simplified Communication:</b> Allows microservices to communicate using logical service names
     *    (e.g., "http://provider-service/api/endpoint") instead of hardcoded server URLs.
     *
     * <b>Example Usage:</b>
     * With @LoadBalanced, you can call: restTemplate.getForObject("http://PROVIDER-SERVICE/api/data", String.class)
     * Without @LoadBalanced, you would need to hardcode: "http://192.168.1.100:8080/api/data"
     *
     * @return the configured RestTemplate instance with client-side load balancing enabled
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
}
