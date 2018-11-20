package com.cs3750.messages;

public class CardMessage extends Message {
	private int card;
	
	public CardMessage(Integer card) {
		super("card");
		this.card = card;
	}
	
	public int getCard() {
		return card;
	}
}
