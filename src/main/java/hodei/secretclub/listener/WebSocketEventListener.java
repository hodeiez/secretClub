package hodei.secretclub.listener;

import hodei.secretclub.models.ChatMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 * Created by Hodei Eceiza
 * Date: 5/9/2021
 * Time: 23:04
 * Project: secretClub
 * Copyright: MIT
 */
@Component
public class WebSocketEventListener {
    private static final Logger logger= LoggerFactory.getLogger(WebSocketEventListener.class);
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;
    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event){
        logger.info("new web socket connection");
    }
    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event){
        StompHeaderAccessor headerAccessor=StompHeaderAccessor.wrap(event.getMessage());

        String username=(String)headerAccessor.getSessionAttributes().get("username");

        if(username!=null){
            logger.info("user disconnected");
            ChatMessage chatMessage=new ChatMessage();
            chatMessage.setType(ChatMessage.MessageType.LEAVE);
            chatMessage.setSender(username);
            messagingTemplate.convertAndSend("/topic/memberChatRoom",chatMessage);
        }
    }

}
