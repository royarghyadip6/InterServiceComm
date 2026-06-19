package com.servicecomm.customer.open_feign;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/open-feign")
public class FeignController {
    private final OpenFeignClient openFeignClient;

    @RequestMapping("/provider-info")
    public String getProviderInfo() {
        return openFeignClient.getInstance();
    }
}
