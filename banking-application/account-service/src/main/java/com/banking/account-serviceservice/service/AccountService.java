package com.banking.accountservice.service;

import com.banking.accountservice.model.Account;
import com.banking.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public Account createAccount(Account account) {
        Account savedAccount = accountRepository.save(account);
        kafkaTemplate.send("account-created", savedAccount.getUserId());
        return savedAccount;
    }

    public List<Account> getAccountsByUserId(String userId) {
        return accountRepository.findByUserId(userId);
    }
}