package com.banking.loanservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "loans")
public class Loan {
    @Id
    private String id;
    private String userId;
    private double amount;
    private double interestRate;
    private int termMonths;
    private String status;
}