    package com.CraftCodeSmith.rtc.controller;

    import com.CraftCodeSmith.rtc.util.SessionHandler;
    import jdk.swing.interop.SwingInterOpUtils;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.messaging.handler.annotation.MessageMapping;
    import org.springframework.messaging.handler.annotation.SendTo;
    import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.socket.WebSocketSession;

    import java.util.concurrent.ConcurrentHashMap;

    @Controller
    public class VideoController {

        @Autowired
        private SessionHandler sessionHandler;

        @MessageMapping("/connect")
        @SendTo("/topic/connected")
        public void connect(String clientId, SimpMessageHeaderAccessor headerAccessor) {

            String sessionId = headerAccessor.getSessionId();
            if (clientId == null || sessionId == null) {
                System.out.println("Failed to connect, client ID or session missing.");
                return;
            }

            // Use sessionHandler to add the session and map it with the clientId
            sessionHandler.addSession(clientId, sessionId);
            sessionHandler.printSessions();
        }

        @MessageMapping("/video")
        @SendTo("/topic/video")
        public String initiateCall(String message) {
            // Handle the signaling message, SDP offer/answer, or ICE candidates
            return message;
        }

        // Add a method to handle disconnect and clean up the session
        public void disconnect(SimpMessageHeaderAccessor headerAccessor) {
            String sessionId = headerAccessor.getSessionId();
            sessionHandler.removeSession(sessionId);
            System.out.println("Session removed for ID: " + sessionId);
        }
    }