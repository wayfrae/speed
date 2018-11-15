package com.cs3750.messages;

import java.util.List;

public class MiddleCards extends Message {
	private List<Integer> cards;
	
	public MiddleCards(List<Integer> cards) {
		super("middle");
		this.cards = cards;
	}
	
	public List<Integer> getCards() {
		return cards;
	}
}
