package com.CraftCodeSmith.rtc.controller;
import com.CraftCodeSmith.rtc.Message.SignalMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;


@Controller
public class SignalingController {

    @Autowired
    SimpMessagingTemplate messagingTemplate;

//    public SignalingController(SimpMessagingTemplate messagingTemplate) {
//        this.messagingTemplate = messagingTemplate;
//    }

    @MessageMapping("/signal")
    @SendTo("/topic/messages")
    public SignalMessage handleSignal(final SignalMessage signalMessage) throws Exception {
        return signalMessage;
    }
}

