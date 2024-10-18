package com.CraftCodeSmith.rtc.controller;
import com.CraftCodeSmith.rtc.Message.SignalMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class SignalingController {

    private final SimpMessagingTemplate messagingTemplate;

    public SignalingController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/signal")
    @SendTo("/topic/messages")
    public SignalMessage handleSignal(SignalMessage signalMessage) {
        return signalMessage; // Broadcast the message to all connected clients
    }
}
