package com.cs3750.messages;

public class CardMessage extends Message {
	private String card;
	
	public CardMessage(String card) {
		super("card");
		this.card = card;
	}
	
	public String getCard() {
		return card;
	}
}
