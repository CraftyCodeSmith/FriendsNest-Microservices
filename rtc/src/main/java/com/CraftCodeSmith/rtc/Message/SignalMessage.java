package com.CraftCodeSmith.rtc.Message;

import com.CraftCodeSmith.rtc.types.ICECandidate;
import com.CraftCodeSmith.rtc.types.RTCSessionDescription;

public class SignalMessage {
    private String type;
    private String target;
    private String sender;
//    private String content;
    private RTCSessionDescription sdp; // SDP data (for "offer" and "answer")
    private ICECandidate candidate; // ICE candidate data (for "ice-candidate")

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

//    public String getContent() {
//        return content;
//    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

//    public void setContent(String content) {
//        this.content = content;
//    }


    public RTCSessionDescription getSdp() {
        return sdp;
    }

    public void setSdp(RTCSessionDescription sdp) {
        this.sdp = sdp;
    }

    public ICECandidate getCandidate() {
        return candidate;
    }

    public void setCandidate(ICECandidate candidate) {
        this.candidate = candidate;
    }
}