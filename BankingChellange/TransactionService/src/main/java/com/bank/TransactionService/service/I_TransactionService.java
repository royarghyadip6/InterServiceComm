package com.bank.TransactionService.service;

import reactor.core.publisher.Mono;

public interface I_TransactionService {
    Mono<String> verifyTransaction(String customerId, String amount);
}
