package com.cs3750.messages;

public class StartMessage extends Message {
	private String username;
	
	public StartMessage(String username) {
		super("start");
		this.username = username;
	}
	
	public StartMessage() {
		super("start");
	}
	
	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
		return "StartMessage [username=" + username + ", type=" + type + ", getUsername()=" + getUsername()
				+ ", getType()=" + getType() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
