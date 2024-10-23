//package com.CraftCodeSmith.rtc.controller;
//
//import com.CraftCodeSmith.rtc.util.SessionHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/session")
//public class SessionController {
//
//    @Autowired
//    private SessionHandler sessionHandlerService;
//
//    @PostMapping("/add")
//    public String addSession(@RequestParam String clientId, @RequestParam String sessionId) {
//        sessionHandlerService.addSession(clientId, sessionId);
//        return "Session added successfully.";
//    }
//
//    @PostMapping("/remove")
//    public String removeSession(@RequestParam String clientId) {
//        sessionHandlerService.removeSession(clientId);
//        return "Session removed successfully.";
//    }
//
//    @GetMapping("/get")
//    public String getSession(@RequestParam String clientId) {
//        String sessionId = sessionHandlerService.getSession(clientId);
//        return sessionId != null ? "Session ID: " + sessionId : "No session found for the given client ID.";
//    }
//
//    @GetMapping("/print")
//    public String printSessions() {
//        sessionHandlerService.printSessions();
//        return "Sessions printed to console.";
//    }
//}
