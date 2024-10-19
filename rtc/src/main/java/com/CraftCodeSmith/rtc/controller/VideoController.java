package com.CraftCodeSmith.rtc.controller;

import com.CraftCodeSmith.rtc.Message.SignalMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class VideoController {

    @MessageMapping("/video-signal")
    @SendTo("/topic/calls")
    public SignalMessage handleVideoSignal(SignalMessage message) {
        return message;
    }
}

