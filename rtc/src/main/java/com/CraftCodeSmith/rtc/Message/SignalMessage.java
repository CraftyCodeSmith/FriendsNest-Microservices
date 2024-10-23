package com.CraftCodeSmith.rtc.Message;

import com.CraftCodeSmith.rtc.types.ClientId;
import com.CraftCodeSmith.rtc.types.ICECandidate;
import com.CraftCodeSmith.rtc.types.RTCSessionDescription;
//import com.CraftCodeSmith.rtc.types.RTCSessionDescription;package com.CraftCodeSmith.rtc.Message;

public class SignalMessage {
    private String type; // e.g., "offer", "answer", "ice-candidate"
    private ClientId sender; // Changed to an external class for sender
    private ClientId target; // Changed to an external class for target
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

    public ClientId getSender() {
        return sender;
    }

    public void setSender(ClientId sender) {
        this.sender = sender;
    }

    public ClientId getTarget() {
        return target;
    }

    public void setTarget(ClientId target) {
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
