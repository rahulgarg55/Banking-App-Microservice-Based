package com.banking.cardservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "cards")
public class Card {
    @Id
    private String id;
    private String userId;
    private String cardNumber;
    private String cardType;
    private double limit;
    private String status;
}