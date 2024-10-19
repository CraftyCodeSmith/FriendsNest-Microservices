package com.CraftCodeSmith.rtc.Message;

public class SignalMessage {
    private String type; // e.g., "offer", "answer", "ice-candidate"
    private String sender; // Unique identifier for the sender
    private String target; // Unique identifier for the target recipient
    private RTCSessionDescription sdp; // SDP data (for "offer" and "answer")
    private ICECandidate candidate; // ICE candidate data (for "ice-candidate")

    public Object getSender() {
        return sender;
    }

    public String getTarget() {
        return target;
    }

    public Object getType() {
        return type;
    }

    // Getters and Setters

    // Inner class for ICE candidates
    public static class ICECandidate {
        private String candidate;
        private String sdpMid;
        private int sdpMLineIndex;
        private String usernameFragment;

        // Getters and Setters
    }

    // Inner class for RTCSessionDescription
    public static class RTCSessionDescription {
        private String type; // "offer" or "answer"
        private String sdp;

        // Getters and Setters
    }
}
