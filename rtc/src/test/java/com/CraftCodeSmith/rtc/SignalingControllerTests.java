//package com.CraftCodeSmith.rtc;
//
//import com.CraftCodeSmith.rtc.controller.SignalingController;
//import com.CraftCodeSmith.rtc.Message.SignalMessage;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
////@SpringBootTest
////@AutoConfigureMockMvc
////public class SignalingControllerTests {
////
////    @MockBean
////    private SimpMessagingTemplate messagingTemplate;
////
////    @Autowired
////    private SignalingController signalingController;
////
////    @Test
////    public void testSignalMessage() {
////        SignalMessage signalMessage = new SignalMessage();
////        signalMessage.setFrom("user1");
////        signalMessage.setTo("user2");
////        signalMessage.setType("offer");
////        signalMessage.setContent("Hello, this is a test!");
////
////        signalingController.handleSignal(signalMessage);
////
////        verify(messagingTemplate, times(1)).convertAndSend("/topic/messages", signalMessage);
////    }
////}
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class SignalingControllerTests {
//
//    @Autowired
//    private SignalingController signalingController;
//
//    @Test
//    public void testSignalMessage() {
//        SignalMessage signalMessage = new SignalMessage();
//        signalMessage.setFrom("user1");
//        signalMessage.setTo("user2");
//        signalMessage.setType("offer");
//        signalMessage.setContent("Hello, this is a test!");
//
////        SignalMessage returnedMessage = signalingController.handleSignal(signalMessage);
//
//        assertEquals(signalMessage, returnedMessage); // Validate the returned message
//    }
//}
