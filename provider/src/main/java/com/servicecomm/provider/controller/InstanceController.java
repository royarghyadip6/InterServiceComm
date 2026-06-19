package com.servicecomm.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rest-template")
public class InstanceController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/provider/provider-info")
    public String providerInfo() {
        return "Hello from provider! Server port: " + serverPort;
    }
}
