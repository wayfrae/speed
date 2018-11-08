package com.cs3750.messages;

public class GameMessage extends Message {
	private String message;
	
	public GameMessage(String message) {
		super("game");
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
