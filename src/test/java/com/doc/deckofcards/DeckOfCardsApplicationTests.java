package com.doc.deckofcards;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.mockito.*;

import com.doc.deckofcards.controller.CardController;
import com.doc.deckofcards.service.CardService;

@SpringBootTest
@Disabled
class DeckOfCardsApplicationTests {
	private Deck mockDeck;

	@Autowired
	CardService cardService;
	CardController cardController;

	@BeforeEach
	void setUp() {
		this.mockDeck = new Deck();
	}
	@Test
	void contextLoads() {
	}

	@Test
	void get_deck_of_cards_should_return_52_cards() {
		assertEquals(52, mockDeck.getDeck().size());
	}

	@Test
	void shuffle_deck_should_shuffle() {
		Card fifthCard = mockDeck .getCard(4);

		assertEquals(fifthCard.getSuit(), "clubs");

		Deck deckToShuffle = new Deck();

		cardService.shuffleDeck();

		assertNotEquals(mockDeck, deckToShuffle);
	}

	@Test
	void testDeal3Card() {
		cardService.drawACard();
		cardService.drawACard();
		cardService.drawACard();

		assertEquals(49, mockDeck.getDeck().size());
	}

	@Test
	public void testGetANewDeck() {
		Mockito.when(cardService.getDeck()).thenReturn(this.mockDeck);

		ResponseEntity<Deck> response = cardController.getANewDeck();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(mockDeck, response.getBody());
	}
}
