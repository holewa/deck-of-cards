package com.doc.deckofcards.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doc.deckofcards.service.CardService;
import com.doc.deckofcards.Card;
import com.doc.deckofcards.Deck;

@RestController
@RequestMapping("api/deck")
public class CardController {

    private CardService cardService;

    private CardController(CardService cardService) {
        this.cardService = cardService;
        cardService.shuffleDeck();
    }

    @GetMapping("/get")
    public ResponseEntity<Deck> getANewDeck() {
        return new ResponseEntity<>(cardService.getDeck(), HttpStatus.OK);
    }

    @GetMapping("/draw")
    public ResponseEntity<Card> drawACard() {
        return new ResponseEntity<>(cardService.drawACard(), HttpStatus.OK);
    }

    @GetMapping("/cardsleft")
    public ResponseEntity<Integer> cardsLeft() {
        return new ResponseEntity<>(cardService.size(), HttpStatus.OK);
    }
}
