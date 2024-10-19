package com.CraftCodeSmith.rtc.controller;

import com.CraftCodeSmith.rtc.Message.SignalMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class CallController {

    private static final Logger logger = LoggerFactory.getLogger(CallController.class);

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    /**
     * Handle signaling messages from clients.
     *
     * @param message SignalingMessage object containing type, sender, target, and data
     */
    @MessageMapping("/call") // Clients send to /app/call
    public void handleCall(@Payload SignalMessage message) throws Exception {
        logger.info("Received message from {} to {}: {}", message.getSender(), message.getTarget(), message.getType());

        // Forward the message to the target client
        messagingTemplate.convertAndSendToUser(message.getTarget(), "/topic/call", message);
    }
}
