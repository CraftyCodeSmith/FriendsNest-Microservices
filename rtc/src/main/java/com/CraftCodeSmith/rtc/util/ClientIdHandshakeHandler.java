package com.CraftCodeSmith.rtc.util;

import com.CraftCodeSmith.rtc.config.StompPrincipal;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;

public class ClientIdHandshakeHandler extends DefaultHandshakeHandler {

    @Override
    protected Principal determineUser(org.springframework.http.server.ServerHttpRequest request,
                                      WebSocketHandler wsHandler,
                                      Map<String, Object> attributes) {

        String clientId = (String) attributes.get("clientId");

        if (clientId != null) {
            return new StompPrincipal(clientId);
        }

        // Fall back to the default behavior if clientId is not found
        return super.determineUser(request, wsHandler, attributes);
    }
}