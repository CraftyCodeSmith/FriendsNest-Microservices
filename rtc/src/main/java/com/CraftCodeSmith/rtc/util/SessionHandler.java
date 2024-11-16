package com.CraftCodeSmith.rtc.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SessionHandler {

    // A concurrent set to store only session IDs (values)
    private final Set<String> activeUsers = ConcurrentHashMap.newKeySet();

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void addSession(String username) {
        activeUsers.add(username);
        sendUpdateToFrontend(); // Send real-time update to frontend
    }

    public void removeSession(String username) {
        activeUsers.remove(username);
        sendUpdateToFrontend(); // Send real-time update to frontend
    }

//    public boolean isSessionActive(String username) {
//        return activeUsers.contains(username);
//    }

    public void printSessions() {
        System.out.println("Active Sessions -----------------------");
        activeUsers.forEach(session -> {
            System.out.println("Session ID: " + session);
        });
    }

    private void sendUpdateToFrontend() {
        messagingTemplate.convertAndSend("/topic/client-update", activeUsers);
    }
}
