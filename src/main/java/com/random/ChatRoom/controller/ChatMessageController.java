package com.random.ChatRoom.controller;

import com.random.ChatRoom.domain.dto.request.ChatMessageRequest;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatMessageController {

    private final SimpMessagingTemplate template;

    public ChatMessageController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/message")
    public void sendMessage(ChatMessageRequest chatMessageRequest) {
        // ChatMessage 객체를 serialize 한 뒤 목적지로 보냄
        template.convertAndSend("/subscribe/chat/room/" + chatMessageRequest.getRoomId(), chatMessageRequest);
    }


}
