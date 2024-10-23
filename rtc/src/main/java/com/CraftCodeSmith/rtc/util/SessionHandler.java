package com.CraftCodeSmith.rtc.util;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import org.springframework.stereotype.Component;
//
//@Component
//public class SessionHandler {
//
//    private final Map<String, String> sessionMap = new ConcurrentHashMap<>();
//
//    /**
//     * Adds a session by its session ID and generates a unique ID for it.
//     *
//     * @param sessionId The session ID to add.
//     */
//    public void addSession(String clientID, String sessionId) {
//        sessionMap.put(clientID, sessionId);
//    }
//
//    /**
//     * Removes a session from the session map using its session ID.
//     *
//     * @param clientId The client ID to remove.
//     */
//    public void removeSession(String clientId) {
//        sessionMap.remove(clientId);
//    }
//
//    public void getSession(String clientId) {
//        sessionMap.get(clientId);
//    }
//
//    /**
//     * Prints all key-value pairs of the session map.
//     */
//    public void printSessions() {
//        sessionMap.forEach((clientId, session) -> {
//            System.out.println("Client ID: " + clientId + ", Session ID: " + sessionMap.get(clientId));
//        });
//    }
//}

import java.util.Map;

import com.CraftCodeSmith.rtc.types.ClientId;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SessionHandler {

//    private final Map<String, String> sessionMap = new ConcurrentHashMap<>();
//
//    /**
//     * Adds a session by its session ID and generates a unique ID for it.
//     *
//     * @param clientID The client ID to add.
//     * @param sessionId The session ID to add.
//     */
//    public void addSession(String clientID, String sessionId) {
//        sessionMap.put(clientID, sessionId);
//    }
//
//    /**
//     * Removes a session from the session map using its client ID.
//     *
//     * @param clientId The client ID to remove.
//     */
//    public void removeSession(String clientId) {
//        sessionMap.remove(clientId);
//    }
//
//    /**
//     * Retrieves the session ID associated with a given client ID.
//     *
//     * @param clientId The client ID to get the session for.
//     * @return The session ID.
//     */
//    public String getSession(String clientId) {
//        return sessionMap.get(clientId);
//    }
//
//    /**
//     * Prints all key-value pairs of the session map.
//     */
//    public void printSessions() {
//        sessionMap.forEach((clientId, session) -> {
//            System.out.println("Client ID: " + clientId + ", Session ID: " + session);
//        });
//    }
//
//    /**
//     * Get all current sessions.
//     * @return Map of client IDs and session IDs.
//     */
//    public Map<String, String> getAllSessions() {
//        return sessionMap;
//    }

    private final Map<String, String> sessionMap = new ConcurrentHashMap<>();

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // Inner class named Key

    public void addSession(String clientID, String sessionId) {
        sessionMap.put(clientID, sessionId);
        sendUpdateToFrontend(); // Send real-time update to frontend
    }

    public void removeSession(String clientId) {
        sessionMap.remove(clientId);
        sendUpdateToFrontend(); // Send real-time update to frontend
    }

    public String getSession(String clientId) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            for (String key : sessionMap.keySet()) {
                // Parse the key as a JSON string
                Map<String, String> parsedKey = objectMapper.readValue(key, Map.class);

                // Check if the clientId matches
                if (parsedKey.containsKey("clientId") && parsedKey.get("clientId").equals(clientId)) {
                    String sessionId = sessionMap.get(key);

                    System.out.println("Session ID: " + sessionId);

                    return  sessionId;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // If no matching clientId is found
        return String.format("No session found for client %s", clientId);
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
