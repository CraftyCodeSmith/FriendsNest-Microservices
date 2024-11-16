package com.CraftCodeSmith.rtc.controller;

import com.CraftCodeSmith.rtc.Message.SignalMessage;
import com.CraftCodeSmith.rtc.config.StompPrincipal;
import com.CraftCodeSmith.rtc.util.SessionHandler;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class VideoController {

    @Autowired
    private SessionHandler sessionHandler;

    @MessageMapping("/connect")
    @SendTo("/topic/connected")
    public void connect(SignalMessage message, SimpMessageHeaderAccessor headerAccessor) {

//        String clientIdStr = message.getSender(); // Now returns String
//        String sessionId = headerAccessor.getSessionId();
        String username = (String) headerAccessor.getSessionAttributes().get("username");
//        if (clientIdStr == null || sessionId == null) {
//            System.out.println("Failed to connect, client ID or session missing.");
//            return;
//        }

        // Create Principal using the clientId string
//        StompPrincipal principal = new StompPrincipal(clientIdStr);

        // Set the principal as the user in the header accessor
//        headerAccessor.setUser(principal);

        // Map the session with the clientId (both are Strings)
        sessionHandler.addSession(username);
    }

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectEvent event) {
        // Handle session connect events if necessary
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String sessionId = headerAccessor.getSessionId();
        // Additional logic for handling new connections can be added here if needed
        System.out.println("A new session connected: " + sessionId);
    }

    @MessageMapping("/video")
    @SendTo("/topic/video")
    public String initiateCall(String message) {
        // Handle the signaling message, SDP offer/answer, or ICE candidates
        return message;
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
//        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
//        String sessionId = headerAccessor.getSessionId();
//        String clientId = sessionHandler.getClientIdBySession(sessionId);
//        sessionHandler.printSessions();
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if (username != null) {
            sessionHandler.removeSession(username);
//            System.out.println("Client disconnected: " + clientId + " with session ID: " + sessionId);
        } else {
//            System.out.println("Session disconnected without a known client ID: " + sessionId);
        }
    }
}
