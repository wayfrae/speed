package com.cs3750.messages;

public class OpponentCards extends Message {
	private int cards;
	
	public OpponentCards(int cards) {
		super("opponent");
		this.cards = cards;
	}
	
	public int getCards() {
		return cards;
	}
}
