package com.CraftCodeSmith.rtc.util;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;

@Component
public class SessionHandler {

    private final Map<String, String> sessionMap = new ConcurrentHashMap<>();

    /**
     * Adds a session by its session ID and generates a unique ID for it.
     *
     * @param sessionId The session ID to add.
     */
    public void addSession(String clientID, String sessionId) {
        sessionMap.put(clientID, sessionId);
    }

    /**
     * Removes a session from the session map using its session ID.
     *
     * @param clientId The client ID to remove.
     */
    public void removeSession(String clientId) {
        sessionMap.remove(clientId);
    }

    public void getSession(String clientId) {
        sessionMap.get(clientId);
    }

    /**
     * Prints all key-value pairs of the session map.
     */
    public void printSessions() {
        sessionMap.forEach((clientId, session) -> {
            System.out.println("Client ID: " + clientId + ", Session ID: " + sessionMap.get(clientId));
        });
    }
}