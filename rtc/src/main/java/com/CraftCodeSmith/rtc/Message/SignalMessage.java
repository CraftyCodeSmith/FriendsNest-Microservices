package com.CraftCodeSmith.rtc.Message;

public class SignalMessage {
    private String type;
    private String target;
    private String sender;
    private String content;

    // Getters and Setters

    public String getType() {
        return type;
    }

    public String getTarget() {
        return target;
    }

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setContent(String content) {
        this.content = content;
    }
}