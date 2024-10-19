package com.CraftCodeSmith.rtc.Message;

public class SignalMessage {
    private String from;
    private String to;
    private String type;
    private String content;
    private String text;

    public String getText(){
        return text;
    }
    public void setText(String text){
        this.text=text;
    }
    // Getter and setter for 'from'

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    // Getter and setter for 'to'
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    // Getter and setter for 'type'
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getter and setter for 'content'
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

//    private String from;
//    private String to;
//    private String type;
//    private String content;
//
//    // Getter and setter for 'from'
//    public String getFrom() {
//        return from;
//    }
//
//    public void setFrom(String from) {
//        this.from = from;
//    }
//
//    // Getter and setter for 'to'
//    public String getTo() {
//        return to;
//    }
//
//    public void setTo(String to) {
//        this.to = to;
//    }
//
//    // Getter and setter for 'type'
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    // Getter and setter for 'content'
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
