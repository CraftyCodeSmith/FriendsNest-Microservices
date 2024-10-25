package com.CraftCodeSmith.rtc.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SessionHandler {

    private final Map<String, String> sessionMap = new ConcurrentHashMap<>();

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void addSession(String clientID, String sessionId) {
        sessionMap.put(clientID, sessionId);
        sendUpdateToFrontend(); // Send real-time update to frontend
    }

    public void removeSession(String clientId) {
        sessionMap.remove(clientId);
        sendUpdateToFrontend(); // Send real-time update to frontend
    }

    public String getSession(String clientId) {
        return sessionMap.get(clientId);
    }

    public String getClientIdBySession(String sessionId) {
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            if (entry.getValue().equals(sessionId)) {
                return entry.getKey();
            }
        }
        return null; // Return null if no match is found
    }

    public void printSessions() {
        System.out.println("Hashmap -----------------------");
        sessionMap.forEach((clientId, session) -> {
            System.out.println("Client ID: " + clientId + ", Session ID: " + session);
        });
    }

    private void sendUpdateToFrontend() {
        messagingTemplate.convertAndSend("/topic/client-update", sessionMap);
    }
}