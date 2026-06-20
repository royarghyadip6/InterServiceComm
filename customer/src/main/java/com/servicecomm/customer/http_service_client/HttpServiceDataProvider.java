package com.servicecomm.customer.http_service_client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.support.RestTemplateAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class HttpServiceDataProvider {

    /**
     *  Examples showing three ways to create an HttpService proxy. Choose one and
     *  uncomment the corresponding block. Notes:
     *  - WebClient (reactive) is non-blocking and requires WebClientAdapter.
     *  - RestClient (Spring Framework 6+) is a newer blocking HTTP client and uses RestClientAdapter.
     *  - RestTemplate is the traditional blocking client and uses RestTemplateAdapter.
     * @return
     */
    @Bean
    public I_HttpServiceInterface httpWebClientServiceInterface() {

        // 1) Reactive (non-blocking) using WebClient:
        /*
        WebClient webClient = WebClient.create("http://localhost:8081");
        WebClientAdapter adapter = WebClientAdapter.create(webClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        return factory.createClient(I_HttpServiceInterface.class);
        */

        // 2) Blocking using RestClient (Spring Framework 6+):
        /*
        RestClient restClient = RestClient.create("http://localhost:8081");
        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        return factory.createClient(I_HttpServiceInterface.class);
        */

        // 3) Blocking using RestTemplate (current active implementation):
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://localhost:8081"));
        RestTemplateAdapter adapter = RestTemplateAdapter.create(restTemplate);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        // create and return the proxied HTTP service directly (no redundant local variable)
        return factory.createClient(I_HttpServiceInterface.class);
    }
}
