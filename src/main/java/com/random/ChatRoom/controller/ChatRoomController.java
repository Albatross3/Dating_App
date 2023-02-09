package com.random.ChatRoom.controller;

import com.random.ChatRoom.domain.dto.request.ChatRoomSaveRequest;
import com.random.ChatRoom.domain.dto.response.ChatRoomSaveResponse;
import com.random.ChatRoom.service.ChatRoomService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    public ChatRoomController(ChatRoomService chatRoomService) {
        this.chatRoomService = chatRoomService;
    }

    @PostMapping("/chat/room")
    public ChatRoomSaveResponse createChatRoom(@RequestBody ChatRoomSaveRequest chatRoomSaveRequest) {
        ChatRoomSaveResponse chatRoomSaveResponse = chatRoomService.saveChatRoom(chatRoomSaveRequest);
        return chatRoomSaveResponse;
    }
}
