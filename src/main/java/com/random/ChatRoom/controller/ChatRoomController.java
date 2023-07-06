package com.random.ChatRoom.controller;

import com.random.ChatRoom.domain.dto.request.ChatRoomSaveRequest;
import com.random.ChatRoom.domain.dto.response.ChatRoomListResponse;
import com.random.ChatRoom.domain.dto.response.ChatRoomSaveResponse;
import com.random.ChatRoom.service.ChatRoomService;
import org.springframework.web.bind.annotation.GetMapping;
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

    // TODO 3/7 같이 최대 인원에 몇명 들어왔는지 확인하는 로직 필요
    @GetMapping("/chat/room")
    public ChatRoomListResponse getChatRoomList() {
        ChatRoomListResponse chatRoomList = chatRoomService.findChatRoomList();
        return chatRoomList;
    }
}
