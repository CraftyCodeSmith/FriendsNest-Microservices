package com.CraftCodeSmith.rtc.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class CustomWebSocketHandler extends TextWebSocketHandler {

    @Autowired
    private SessionHandler sessionHandler;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // Store the session and generate a unique ID for it
        String uniqueId = sessionHandler.addSession(session);
        // Optionally, notify the peer with their unique ID
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // Remove the session when the peer disconnects
        sessionHandler.removeSession(session);
    }
}
