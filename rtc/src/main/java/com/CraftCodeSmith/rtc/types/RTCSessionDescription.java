package com.CraftCodeSmith.rtc.types;

public class RTCSessionDescription {
    private String type; // "offer" or "answer"
    private String sdp;

    // Default Constructor
    public RTCSessionDescription() {
    }

    // Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSdp() {
        return sdp;
    }

    public void setSdp(String sdp) {
        this.sdp = sdp;
    }
}
