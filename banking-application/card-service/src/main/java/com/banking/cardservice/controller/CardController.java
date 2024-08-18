package com.banking.cardservice.controller;

import com.banking.cardservice.model.Card;
import com.banking.cardservice.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<Card> applyForCard(@RequestBody Card card) {
        return ResponseEntity.ok(cardService.applyForCard(card));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Card>> getCardsByUserId(@PathVariable String userId) {
        List<Card> cards = cardService.getCardsByUserId(userId);
        if (!cards.isEmpty()) {
            return ResponseEntity.ok(cards);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}