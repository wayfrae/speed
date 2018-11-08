package com.cs3750.messages;

public class PlayerCards extends Message {
	private String[] cards;
	
	public PlayerCards(String[] cards) {
		super("player");
		this.cards = cards;
	}
	
	public String[] getCards() {
		return cards;
	}
}
