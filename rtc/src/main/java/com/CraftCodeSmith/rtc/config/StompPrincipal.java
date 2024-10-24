package com.CraftCodeSmith.rtc.config;

import java.security.Principal;
import java.util.UUID;

public class StompPrincipal implements Principal {
    private final String name;

    public StompPrincipal(UUID name) {
        this.name = ""+name;
    }

    @Override
    public String getName() {
        return name;
    }
}