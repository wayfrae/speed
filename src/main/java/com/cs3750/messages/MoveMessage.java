package com.cs3750.messages;

public class MoveMessage extends Message {
	private int from;
	private int to;
	
	public MoveMessage(int from, int to) {
		super("move");
		this.from = from;
		this.to = to;
	}
	
	public int getFrom() {
		return from;
	}
	
	public int getTo() {
		return to;
	}
}
