package com.CraftCodeSmith.rtc.services;

import com.CraftCodeSmith.rtc.util.SessionHandler;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.UUID;

public class messagingservice {

    private final SessionHandler sessionHandler;
    private final SimpMessagingTemplate messagingTemplate;

    public messagingservice(SessionHandler SessionHandler, SimpMessagingTemplate messagingTemplate) {
        this.sessionHandler = SessionHandler;
        this.messagingTemplate = messagingTemplate;
    }

    public void sendMessageToClient(UUID clientId, String message) {
        String sessionId = sessionHandler.getSession(clientId);
        if (sessionId != null) {
            messagingTemplate.convertAndSendToUser(sessionId, "/topic/yourDestination", message);
        }
    }
}
