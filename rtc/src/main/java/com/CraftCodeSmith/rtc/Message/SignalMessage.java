package com.CraftCodeSmith.rtc.Message;

import java.util.UUID;
import com.CraftCodeSmith.rtc.types.ICECandidate;
import com.CraftCodeSmith.rtc.types.RTCSessionDescription;

public class SignalMessage {
    private String type; // e.g., "offer", "answer", "ice-candidate"
    private UUID sender; // Changed to UUID for sender
    private UUID target; // Changed to UUID for target
    private RTCSessionDescription sdp; // SDP data (for "offer" and "answer")
    private ICECandidate candidate; // ICE candidate data (for "ice-candidate")

    // Default Constructor
    public SignalMessage() {
    }

    // Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UUID getSender() {
        return sender;
    }

    public void setSender(UUID sender) {
        this.sender = sender;
    }

    public UUID getTarget() {
        return target;
    }
    public void setTarget(UUID target) {
        this.target = target;
    }

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
