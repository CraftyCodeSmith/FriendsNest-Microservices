package com.CraftCodeSmith.rtc.controller;

import com.CraftCodeSmith.rtc.Message.SignalMessage;
import com.CraftCodeSmith.rtc.util.SessionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Controller;

@Controller
public class CallController {

    private static final Logger logger = LoggerFactory.getLogger(CallController.class);

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private SessionHandler sessionHandler;

    @Autowired
    private SimpUserRegistry simpUserRegistry;

    @MessageMapping("/call")
    public void handleCall(@Payload SignalMessage message) throws Exception {
        if ("offer".equals(message.getType())) {
            String recipient = message.getTarget().toString();
            messagingTemplate.convertAndSendToUser(recipient, "/queue/call", message);
        }
    }
}
