//package com.CraftCodeSmith.rtc.interceptor;
//
//import com.CraftCodeSmith.rtc.config.StompPrincipal;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.web.socket.WebSocketHandler;
//import org.springframework.web.socket.server.HandshakeInterceptor;
//
//import java.util.Map;
//
//public class UserHandshakeInterceptor implements HandshakeInterceptor {
//
//    @Override
//    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
//                                   WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
//        // Extract clientId from request parameters or headers
//        String clientId = extractClientId(request);
//        if (clientId == null) {
//            return false; // Reject the handshake if clientId is missing
//        }
//        // Assign the clientId as the Principal name
//        attributes.put("principal", new StompPrincipal(clientId));
//        return true;
//    }
//
//    @Override
//    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
//                               WebSocketHandler wsHandler, Exception exception) {
//        // No implementation needed
//    }
//
//    private String extractClientId(ServerHttpRequest request) {
//        // Implement logic to extract clientId from the request
//        // For example, from query parameters:
//        // URI uri = request.getURI();
//        // String query = uri.getQuery();
//        // Parse the query string to get clientId
//        return /* extracted clientId */;
//    }
//}
