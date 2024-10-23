    package com.CraftCodeSmith.rtc.controller;

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

    import java.util.Map;
    import java.util.concurrent.ConcurrentHashMap;

    @Controller
    public class VideoController {

        @Autowired
        private SessionHandler sessionHandler;

        @MessageMapping("/connect")
        @SendTo("/topic/connected")
        public void connect(String clientId, SimpMessageHeaderAccessor headerAccessor) {

//            String activeSes = headerAccessor.getSessionAttributes().get("sessionId").toString();
//            System.out.println(activeSes);

            String sessionId = headerAccessor.getSessionId();
            if (clientId == null || sessionId == null) {
                System.out.println("Failed to connect, client ID or session missing.");
                return;
            }

            // Use sessionHandler to add the session and map it with the clientId
            sessionHandler.addSession(clientId, sessionId);
            sessionHandler.getSession(clientId);
        }

        @MessageMapping("/video")
        @SendTo("/topic/video")
        public String initiateCall(String message) {
            // Handle the signaling message, SDP offer/answer, or ICE candidates
            return message;
        }

        @EventListener
        public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
            StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
            String sessionId = headerAccessor.getSessionId();
            String clientId = sessionHandler.getClientIdBySession(sessionId);

            // If clientId is present, remove it from the session handler
            if (clientId != null) {
                sessionHandler.removeSession(clientId);
                System.out.println("Client disconnected: " + clientId + " with session ID: " + sessionId);
            } else {
                System.out.println("Session disconnected without a known client ID: " + sessionId);
            }
        }

        // Add a method to handle disconnect and clean up the session
        public void disconnect(SimpMessageHeaderAccessor headerAccessor) {
            String sessionId = headerAccessor.getSessionId();
            sessionHandler.removeSession(sessionId);
            sessionHandler.printSessions();
            System.out.println("Session removed for ID: " + sessionId);
        }
    }