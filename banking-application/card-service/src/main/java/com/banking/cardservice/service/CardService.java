package com.banking.cardservice.service;

import com.banking.cardservice.model.Card;
import com.banking.cardservice.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public Card applyForCard(Card card) {
        card.setStatus("PENDING");
        Card savedCard = cardRepository.save(card);
        kafkaTemplate.send("card-applied", savedCard.getUserId());
        return savedCard;
    }

    public List<Card> getCardsByUserId(String userId) {
        return cardRepository.findByUserId(userId);
    }
}