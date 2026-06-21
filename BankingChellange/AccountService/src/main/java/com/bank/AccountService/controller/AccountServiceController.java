package com.bank.AccountService.controller;

import com.bank.AccountService.model.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/account")
public class AccountServiceController {

    @GetMapping
    public static List<Account> getDummyAccounts() {
        List<Account> accounts = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        accounts.add(new Account(1L, "ACC-2026-1001", 501L, "SAVINGS", 1500.50, now, now));
        accounts.add(new Account(2L, "ACC-2026-1002", 502L, "CHECKING", 25000.00, now, now));
        accounts.add(new Account(3L, "ACC-2026-1003", 503L, "SAVINGS", 50.75, now, now));
        accounts.add(new Account(4L, "ACC-2026-1004", 504L, "WALLET", 320.00, now, now));
        accounts.add(new Account(5L, "ACC-2026-1005", 505L, "SAVINGS", 0.00, now, now));
        accounts.add(new Account(6L, "ACC-2026-1006", 506L, "CHECKING", 8450.25, now, now));
        accounts.add(new Account(7L, "ACC-2026-1007", 507L, "SAVINGS", 124500.80, now, now));
        accounts.add(new Account(8L, "ACC-2026-1008", 508L, "WALLET", 15.00, now, now));
        accounts.add(new Account(9L, "ACC-2026-1009", 509L, "SAVINGS", 6700.00, now, now));
        accounts.add(new Account(10L, "ACC-2026-1010", 510L, "CHECKING", 1050.10, now, now));

        return accounts;
    }

    @GetMapping("/{custId}/balance")
    public ResponseEntity<Account> getUserByIdAndBalance(@PathVariable Long custId) {
        Optional<Account> account =
                getDummyAccounts().stream().filter(a -> a.getCustomerId().equals(custId)).findFirst();
        return ResponseEntity.ok(account.get());
    }
}
