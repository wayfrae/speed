package com.cs3750.messages;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

public class MessageFactory {
	
	public String getConnectMessage(ConnectMessage connectMessage) {
		return getConnectMessage(connectMessage.getUsername());
	}
	
	public String getConnectMessage(String username) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "connect");
		objBuilder.add("username", username);
		
		return objBuilder.build().toString();
	}
	
	public static String getDrawMessage(DrawMessage drawMessage) {
		return getDrawMessage();
	}
	
	public static String getDrawMessage() {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "draw");
		
		return objBuilder.build().toString();
	}
	
	public static String getMoveMessage(MoveMessage moveMessage) {
		return getMoveMessage(moveMessage.getFrom(), moveMessage.getTo());
	}
	
	public static String getMoveMessage(int from, int to) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "move");
		objBuilder.add("from", from);
		objBuilder.add("to", to);
		
		return objBuilder.build().toString();
	}
	
	public static String getCardMessage(CardMessage cardMessage) {
		return getCardMessage(cardMessage.getCard());
	}
	
	public static String getCardMessage(String card) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "card");
		objBuilder.add("card", card);
		
		return objBuilder.build().toString();
	}
	
	public static String getChatMessage(ChatMessage chatMessage) {
		return getChatMessage(chatMessage.getMessage(), chatMessage.getUsername());
	}
	
	public static String getChatMessage(String message, String username) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "chat");
		objBuilder.add("username", username);
		objBuilder.add("message", message);
		
		return objBuilder.build().toString();
	}
	
	public static String getGameMessage(GameMessage gameMessage) {
		return getGameMessage(gameMessage.getMessage());
	}
	
	public static String getGameMessage(String message) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "game");
		objBuilder.add("message", message);
		
		return objBuilder.build().toString();
	}
	
	public static String getInvalidMessage(InvalidMessage invalidMessage) {
		return getInvalidMessage(invalidMessage.getMessage());
	}
	
	public static String getInvalidMessage(String message) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "invalid");
		objBuilder.add("message", message);
		
		return objBuilder.build().toString();
	}
	
	public String getMiddleCards(MiddleCards middleCards) {
		return getMiddleCards(middleCards.getCards());
	}
	
	public static String getMiddleCards(String[] cards) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "middle");
		
		JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
		
		for (String s : cards) {
			arrBuilder.add(Json.createObjectBuilder().add("card", s));
		}
		
		objBuilder.add("cards", arrBuilder);
		
		return objBuilder.build().toString();
	}
	
	public static String getOpponentCards(OpponentCards opponentCards) {
		return getOpponentCards(opponentCards.getCards());
	}
	
	public static String getOpponentCards(int cards) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "opponent");
		objBuilder.add("cards", cards);
		
		return objBuilder.build().toString();
	}
	
	public static String getPlayerCards(PlayerCards playerCards) {
		return getPlayerCards(playerCards.getCards());
	}
	
	public static String getPlayerCards(String[] cards) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "player");
		
		JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
		
		for (String s : cards) {
			arrBuilder.add(Json.createObjectBuilder().add("card", s));
		}
		
		objBuilder.add("cards", arrBuilder);
		
		return objBuilder.build().toString();
	}
	
	public static String getStartMessage(StartMessage startMessage) {
		return getStartMessage(startMessage.getUsername());
	}
	
	public static String getStartMessage(String username) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "start");
		objBuilder.add("username", username);
		
		return objBuilder.build().toString();
	}
}
