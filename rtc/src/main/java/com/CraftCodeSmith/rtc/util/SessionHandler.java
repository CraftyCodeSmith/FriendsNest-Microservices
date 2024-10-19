package com.CraftCodeSmith.rtc.util;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.UUID;

@Component
public class SessionHandler {

    private final Map<String, String> sessionMap = new ConcurrentHashMap<>();

    public String addSession(WebSocketSession session) {
        String uniqueId = UUID.randomUUID().toString();
        sessionMap.put(session.getId(), uniqueId);
        return uniqueId;
    }

    public String getUniqueId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(WebSocketSession session) {
        sessionMap.remove(session.getId());
    }
}
