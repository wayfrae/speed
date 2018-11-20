package com.cs3750.messages;

public class ConnectMessage extends Message {
	private String username;

	public ConnectMessage(String username) {
		super("connect");
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
}
