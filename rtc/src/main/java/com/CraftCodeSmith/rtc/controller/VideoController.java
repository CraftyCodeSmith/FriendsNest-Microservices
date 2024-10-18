package com.CraftCodeSmith.rtc.controller;

import com.CraftCodeSmith.rtc.Message.SignalMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class VideoController {

    @MessageMapping("/signal")
    @SendTo("/topic/calls")
    public SignalMessage handleSignal(SignalMessage message) {
        return message; // Echo the message back to all subscribers
    }
}

