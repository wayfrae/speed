package com.cs3750.messages;

public class MoveMessage extends Message {
	private Integer from;
	private Integer to;
	private String username;
	
	public MoveMessage(String username, Integer from, Integer to) {
		super("move");
		this.from = from;
		this.to = to;
	}
	
	public Integer getFrom() {
		return from;
	}
	
	public Integer getTo() {
		return to;
	}
}
