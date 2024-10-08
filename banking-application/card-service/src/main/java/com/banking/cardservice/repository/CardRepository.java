package com.banking.cardservice.repository;

import com.banking.cardservice.model.Card;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CardRepository extends MongoRepository<Card, String> {
    List<Card> findByUserId(String userId);
}