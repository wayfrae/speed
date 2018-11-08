package com.cs3750.messages;

public class MiddleCards extends Message {
	private String[] cards;
	
	public MiddleCards(String[] cards) {
		super("middle");
		this.cards = cards;
	}
	
	public String[] getCards() {
		return cards;
	}
}
