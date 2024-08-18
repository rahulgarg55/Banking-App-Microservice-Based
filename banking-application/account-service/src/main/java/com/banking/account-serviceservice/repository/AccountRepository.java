package com.banking.accountservice.repository;

import com.banking.accountservice.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AccountRepository extends MongoRepository<Account, String> {
    List<Account> findByUserId(String userId);
}