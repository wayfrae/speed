package com.cs3750.messages;

public class InvalidMessage extends Message {
	private String message;
	
	public InvalidMessage(String message) {
		super("invalid");
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
