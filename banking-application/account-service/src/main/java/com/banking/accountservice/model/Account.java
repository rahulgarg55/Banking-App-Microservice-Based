package com.banking.accountservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "accounts")
public class Account {
    @Id
    private String id;
    private String userId;
    private String accountNumber;
    private double balance;
    private String accountType;
}