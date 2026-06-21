package com.bank.TransactionService.httpclient;

import com.bank.TransactionService.model.Account;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import reactor.core.publisher.Mono;

@HttpExchange
public interface I_HttpServiceClient {
    @GetExchange("/api/account/{custId}/balance")
    Mono<Account> getAccountData(@PathVariable String custId);
}
