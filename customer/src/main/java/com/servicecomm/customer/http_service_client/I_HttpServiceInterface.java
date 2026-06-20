package com.servicecomm.customer.http_service_client;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface I_HttpServiceInterface {
    @GetExchange("/api/rest-template/provider/provider-info")
    String getProviderInfo();
}
