package com.doc.deckofcards.service;


import java.util.AbstractList;
import java.util.Collections;

import org.springframework.stereotype.Service;

import com.doc.deckofcards.Card;
import com.doc.deckofcards.Deck;

@Service
public class CardService extends AbstractList<Card> {
	private Deck deck = new Deck();	

	public void shuffleDeck() {
		Collections.shuffle(this.deck.getDeck());
	}

	public Card drawACard() {
		//draw the first card
		Card firstCard = this.deck.getCard(0);

		//remove it from the Deck
		this.deck.getDeck().remove(firstCard);

		return firstCard;
	}


	public Deck getDeck() {
		return this.deck;
	}


	@Override
	public int size() {
		return this.deck.getDeck().size();
	}

	@Override
	public Card get(int index) {
		return this.deck.getDeck().get(index);
	}
}
