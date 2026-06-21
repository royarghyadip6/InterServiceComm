package com.bank.TransactionService.controller;

import com.bank.TransactionService.httpclient.I_HttpServiceClient;
import com.bank.TransactionService.model.Account;
import com.bank.TransactionService.service.I_TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transactions")
public class TransactionController {

    private final I_TransactionService transactionService;

    @PostMapping("/process")
    public ResponseEntity<Mono<String>> makeTransaction(
            @RequestParam Map<String, String> requestParams
    ) {
        System.out.println("Making transaction. requestParams: " + requestParams);
        String customerId = requestParams.get("customerId");
        String amount = requestParams.get("amount");

        Mono<String> result= transactionService.verifyTransaction(customerId,amount);
        return ResponseEntity.ok(result);
    }
}
