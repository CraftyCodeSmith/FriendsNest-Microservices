package com.CraftCodeSmith.rtc.controller;

import com.CraftCodeSmith.rtc.Message.SignalMessage;
import com.CraftCodeSmith.rtc.util.SessionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUser;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CallController {

    private static final Logger logger = LoggerFactory.getLogger(CallController.class);

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private SessionHandler sessionHandler;

    @Autowired
    private SimpUserRegistry simpUserRegistry;

    /**
     * Handle signaling messages from clients.
     *
     * @param message SignalingMessage object containing type, sender, target, and data
     */
    @MessageMapping("/call") // Clients send to /app/call
    public void handleCall(@Payload SignalMessage message) throws Exception {

        if( message.getType().equals("offer")) {

            // Log or use the sender and target client IDs directly
            System.out.println("Type: " + message.getType());
            System.out.println("Sender Client ID: " + message.getSender().getClientId());
            System.out.println("Target Client ID: " + message.getTarget().getClientId());

            // Retrieve the session IDs for sender and target clients
            String clientSessionId = sessionHandler.getSession(message.getSender().getClientId());
            String targetSessionId = sessionHandler.getSession(message.getTarget().getClientId());
            // Log session IDs if needed
            System.out.println("Client Session ID: " + clientSessionId);
            System.out.println("Target Session ID: " + targetSessionId);

//            messagingTemplate.convertAndSendToUser( targetSessionId,"/topic/call",clientSessionId);
            messagingTemplate.convertAndSend("/topic/call",  targetSessionId);
        }


    }
}
