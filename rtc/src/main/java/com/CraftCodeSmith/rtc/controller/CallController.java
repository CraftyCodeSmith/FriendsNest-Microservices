package com.CraftCodeSmith.rtc.controller;
import com.CraftCodeSmith.rtc.Message.SignalMessage;
import com.CraftCodeSmith.rtc.config.StompPrincipal;
import com.CraftCodeSmith.rtc.util.SessionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.messaging.SessionConnectEvent;

import java.security.Principal;
import java.util.UUID;

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

        if ("offer".equals(message.getType())) {
            String recipient = message.getTarget().toString();


            // Log the message details


            messagingTemplate.convertAndSendToUser(recipient, "/queue/call", message);
        }

        if (message.getType().equals("answer")) {
        }
    }
}
