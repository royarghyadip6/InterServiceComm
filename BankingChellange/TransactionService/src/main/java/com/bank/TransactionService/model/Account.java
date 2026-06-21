package com.bank.TransactionService.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Account {
    private Long id;
    private String accountNumber;
    private Long customerId;
    private String accountType;
    private Double balance = 0.0;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
