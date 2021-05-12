package hodei.secretclub.controllers;

import hodei.secretclub.models.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

/**
 * Created by Hodei Eceiza
 * Date: 5/10/2021
 * Time: 13:09
 * Project: secretClub
 * Copyright: MIT
 */
@Controller
public class WebSocketController {
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/memberChatRoom")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage){
        return chatMessage;
    }
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/memberChatRoom")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("username",chatMessage.getSender());
        return chatMessage;
    }
}
