package com.doc.deckofcards;

import lombok.Data;

@Data
public class Card {
	private int value;
	private String suit;

	public Card(int value, String suit) {
		this.value = value;
		this.suit = suit;
	}
	public String toString() {
		return this.value + " of " + this.suit;
	}
}
