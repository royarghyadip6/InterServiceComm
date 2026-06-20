package com.servicecomm.customer.web_client;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/web-client")
public class WebClientController {

    private final WebClientDataProvider webClientDataProvider;

    /**
     * Controller that demonstrates using Spring's reactive WebClient to call
     * another service and return its String response as a Mono.
     *
     * This method is fully reactive: it returns a {@code Mono<String>} which
     * will be written to the HTTP response when the upstream call completes.
     *
     * Usage notes:
     * - Run the provider service on http://localhost:8081 before calling this
     *   endpoint.
     * - Because this returns a {@code Mono}, the thread calling this method is
     *   not blocked while waiting for the response.
     *
     * @return Mono emitting the provider information as a String
     */
    @GetMapping("/simple-provider-info")
    public Mono<String> simpleProviderInfo() {
        // Create a simple WebClient instance pointing at the provider service.
        WebClient webClient = WebClient.create("http://localhost:8081");

        // Perform a GET request and return the body as a Mono<String>.
        return webClient.get()
                .uri("/api/rest-template/provider/provider-info")
                .retrieve()
                .bodyToMono(String.class);
//                .block(); // block() converts reactive call to a synchronous one (returns string);
    }

    @GetMapping("/advance-provider-info")
    public Mono<String> advanceProviderInfo() {
        return webClientDataProvider.getProviderInfo();
    }
}
