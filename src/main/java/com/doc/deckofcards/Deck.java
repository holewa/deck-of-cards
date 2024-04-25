package com.doc.deckofcards;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Deck {
	private ArrayList<Card> deck = new ArrayList<>();
	private int[] values = {2 ,3 ,4, 5 ,6 ,7 ,8 ,9 ,10 ,11 ,12 ,13 ,14};
	private String[] suits = {"clubs", "diamonds",  "hearts", "spades"};

	public Deck () {
		for (String suit : this.suits) {
			for (int value : this.values) {
				Card card = new Card(value, suit);
				deck.add(card);
			}
		}
	}

	public Card getCard(int index) {
		return this.deck.get(index);
	}

	public ArrayList<Card> getDeck() {
		return this.deck;
	}
}
