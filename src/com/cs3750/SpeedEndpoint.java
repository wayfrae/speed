package com.cs3750;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonReader;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.cs3750.messages.Message;

@ServerEndpoint("/game")
public class SpeedEndpoint {
	private ArrayList<Session> connections = new ArrayList<Session>();
    
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("onOpen::" + session.getId());    
        connections.add(session);
    }
    
    @OnClose
    public void onClose(Session session) {
        System.out.println("onClose::" +  session.getId());
        connections.remove(session);
    }
    
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("onMessage::From=" + session.getId() + " Message=" + message);
        
        try {
            session.getBasicRemote().sendText("Hello Client " + session.getId() + "!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @OnError
    public void onError(Throwable t) {
        System.out.println("onError::" + t.getMessage());
    }
}
