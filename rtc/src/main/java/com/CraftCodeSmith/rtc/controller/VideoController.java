package com.CraftCodeSmith.rtc.controller;

import com.CraftCodeSmith.rtc.util.SessionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketSession;

@Controller
public class VideoController {

    @Autowired
    private SessionHandler sessionHandler;

    @MessageMapping("/connect")
    @SendTo("/topic/connected")
    public String connect(WebSocketSession session) {
        // Generate and store a unique ID for this session
        String uniqueId = sessionHandler.addSession(session);
        return uniqueId; // Send the unique ID back to the client
    }

    @MessageMapping("/call")
    @SendTo("/topic/call")
    public String initiateCall(String message) {
        // Handle the signaling message, SDP offer/answer, or ICE candidates
        return message;
    }

    // Add a method to handle disconnect and clean up the session
}
