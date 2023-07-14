package com.random.ChatRoom.presentation.api;

import com.random.ChatRoom.core.chatroom.dto.request.ChatRoomSaveRequest;
import com.random.ChatRoom.core.chatroom.dto.response.ChatRoomListResponse;
import com.random.ChatRoom.core.chatroom.dto.response.ChatRoomSaveResponse;
import com.random.ChatRoom.core.chatroom.service.ChatRoomService;
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

//  @PostMapping("/chat/room")
//  public ChatRoomSaveResponse createChatRoom(@RequestBody ChatRoomSaveRequest chatRoomSaveRequest) {
//    ChatRoomSaveResponse chatRoomSaveResponse = chatRoomService.saveChatRoom(chatRoomSaveRequest);
//    return chatRoomSaveResponse;
//  }

//  @GetMapping("/chat/room")
//  public ChatRoomListResponse getChatRoomList() {
//    ChatRoomListResponse chatRoomList = chatRoomService.findChatRoomList();
//    return chatRoomList;
//  }
}
