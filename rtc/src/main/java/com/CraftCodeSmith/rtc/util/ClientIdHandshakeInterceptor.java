package com.CraftCodeSmith.rtc.util;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.util.MultiValueMap;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

public class ClientIdHandshakeInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {

        String clientId = null;

        // Extract clientId from query parameters using the request URI
        URI uri = request.getURI();
        MultiValueMap<String, String> queryParams = UriComponentsBuilder.fromUri(uri).build().getQueryParams();
        clientId = queryParams.getFirst("clientId");

        // If not found in query parameters, extract from headers
        if (clientId == null) {
            List<String> clientIdHeaders = request.getHeaders().get("clientId");
            if (clientIdHeaders != null && !clientIdHeaders.isEmpty()) {
                clientId = clientIdHeaders.get(0);
            }
        }

        if (clientId != null) {
            attributes.put("clientId", clientId);
        } else {
            // Handle the case where clientId is missing
            System.out.println("clientId not provided during handshake.");
            // Optionally, you can return false to reject the handshake
            // return false;
        }

        return true;
    }


    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
        // No action needed after handshake
    }
}