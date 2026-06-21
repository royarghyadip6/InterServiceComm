package com.bank.TransactionService.service;

import com.bank.TransactionService.httpclient.I_HttpServiceClient;
import com.bank.TransactionService.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements I_TransactionService{

    private final I_HttpServiceClient httpServiceClient;

    @Override
    public Mono<String> verifyTransaction(String customerId, String amount) {
        long parsedAmount = Long.parseLong(amount);

        return httpServiceClient.getAccountData(customerId)
                    .map(account -> {
                        // This logic executes automatically as soon as the Account data arrives
                        if (account.getBalance() >= parsedAmount) {
                            return "Transaction Approved. $" + amount + " debited from account " + customerId;
                        } else {
                            return "Transaction Rejected. Insufficient balance in account " + customerId;
                        }
                    })
                    // Handles cases where the downstream service returns an empty body or 404
                    .defaultIfEmpty("Transaction Rejected. Account " + customerId + " not found.")
                    // 💡 Reactive "Try-Catch" for Service Unavailable / Connection Failures
                    .onErrorResume(exception -> {
                        // Log the issue for debugging visibility
                        System.err.println("Downstream service communication failed: " + exception.getMessage());

                        // Return a graceful fallback error message instead of throwing a 500 crash
                        return Mono.just("Transaction Status Unknown. The Account Verification Service is currently unavailable. Please try again later.");
                    });
    }
}
