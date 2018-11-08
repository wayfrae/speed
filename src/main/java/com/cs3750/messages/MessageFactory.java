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
	
	public String getDrawMessage(DrawMessage drawMessage) {
		return getDrawMessage();
	}
	
	public String getDrawMessage() {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "draw");
		
		return objBuilder.build().toString();
	}
	
	public String getMoveMessage(MoveMessage moveMessage) {
		return getMoveMessage(moveMessage.getFrom(), moveMessage.getTo());
	}
	
	public String getMoveMessage(int from, int to) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "move");
		objBuilder.add("from", from);
		objBuilder.add("to", to);
		
		return objBuilder.build().toString();
	}
	
	public String getCardMessage(CardMessage cardMessage) {
		return getCardMessage(cardMessage.getCard());
	}
	
	public String getCardMessage(String card) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "card");
		objBuilder.add("card", card);
		
		return objBuilder.build().toString();
	}
	
	public String getChatMessage(ChatMessage chatMessage) {
		return getChatMessage(chatMessage.getMessage(), chatMessage.getUsername());
	}
	
	public String getChatMessage(String message, String username) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "chat");
		objBuilder.add("username", username);
		objBuilder.add("message", message);
		
		return objBuilder.build().toString();
	}
	
	public String getGameMessage(GameMessage gameMessage) {
		return getGameMessage(gameMessage.getMessage());
	}
	
	public String getGameMessage(String message) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "game");
		objBuilder.add("message", message);
		
		return objBuilder.build().toString();
	}
	
	public String getInvalidMessage(InvalidMessage invalidMessage) {
		return getInvalidMessage(invalidMessage.getMessage());
	}
	
	public String getInvalidMessage(String message) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "invalid");
		objBuilder.add("message", message);
		
		return objBuilder.build().toString();
	}
	
	public String getMiddleCards(MiddleCards middleCards) {
		return getMiddleCards(middleCards.getCards());
	}
	
	public String getMiddleCards(String[] cards) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "middle");
		
		JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
		
		for (String s : cards) {
			arrBuilder.add(Json.createObjectBuilder().add("card", s));
		}
		
		objBuilder.add("cards", arrBuilder);
		
		return objBuilder.build().toString();
	}
	
	public String getOpponentCards(OpponentCards opponentCards) {
		return getOpponentCards(opponentCards.getCards());
	}
	
	public String getOpponentCards(int cards) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "opponent");
		objBuilder.add("cards", cards);
		
		return objBuilder.build().toString();
	}
	
	public String getPlayerCards(PlayerCards playerCards) {
		return getPlayerCards(playerCards.getCards());
	}
	
	public String getPlayerCards(String[] cards) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "player");
		
		JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
		
		for (String s : cards) {
			arrBuilder.add(Json.createObjectBuilder().add("card", s));
		}
		
		objBuilder.add("cards", arrBuilder);
		
		return objBuilder.build().toString();
	}
	
	public String getStartMessage(StartMessage startMessage) {
		return getStartMessage(startMessage.getUsername());
	}
	
	public String getStartMessage(String username) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("type", "start");
		objBuilder.add("username", username);
		
		return objBuilder.build().toString();
	}
}
