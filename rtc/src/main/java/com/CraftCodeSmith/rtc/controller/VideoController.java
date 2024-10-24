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
                UUID clientId = message.getSender(); // Get the client ID from the message
                String sessionId = headerAccessor.getSessionId();

                if (clientId == null || sessionId == null) {
                    System.out.println("Failed to connect, client ID or session missing.");
                    return;
                }

                // Create a StompPrincipal using the clientId
                StompPrincipal principal = new StompPrincipal(clientId);
                System.out.println("Principle name ***********"+principal.getName());
                // Set the principal as the user in the header accessor
                headerAccessor.setUser(principal);

                // Use sessionHandler to add the session and map it with the clientId
                sessionHandler.addSession(clientId, sessionId);
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
                StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
                String sessionId = headerAccessor.getSessionId();
                UUID clientId = sessionHandler.getClientIdBySession(sessionId);
                sessionHandler.printSessions();

                if (clientId != null) {
                    sessionHandler.removeSession(clientId);
                    System.out.println("Client disconnected: " + clientId + " with session ID: " + sessionId);
                } else {
                    System.out.println("Session disconnected without a known client ID: " + sessionId);
                }
            }
        }
