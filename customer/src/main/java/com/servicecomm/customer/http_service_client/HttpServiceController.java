package com.servicecomm.customer.http_service_client;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/http-interface")
public class HttpServiceController {

    private final I_HttpServiceInterface httpWebClientService;

    @GetMapping("/provider-info")
    public String getProviderInfo(){
        return httpWebClientService.getProviderInfo();
    }
}
