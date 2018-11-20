package com.cs3750.messages;

public class ChatMessage extends Message {
	private String message;
	private String username;
	
	public ChatMessage(String message, String username) {
		super("chat");
		this.message = message;
		this.username = username;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String getUsername() {
		return username;
	}
}
