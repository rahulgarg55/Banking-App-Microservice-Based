package com.banking.accountservice.controller;

import com.banking.accountservice.model.Account;
import com.banking.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.createAccount(account));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Account>> getAccountsByUserId(@PathVariable String userId) {
        List<Account> accounts = accountService.getAccountsByUserId(userId);
        if (!accounts.isEmpty()) {
            return ResponseEntity.ok(accounts);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}