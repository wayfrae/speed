package com.cs3750.messages;

public class CardMessage extends Message {
	private Integer card;
	
	public CardMessage(Integer card) {
		super("card");
		this.card = card;
	}
	
	public Integer getCard() {
		return card;
	}
}
