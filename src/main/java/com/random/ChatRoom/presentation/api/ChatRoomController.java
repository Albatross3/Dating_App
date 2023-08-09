package com.random.ChatRoom.presentation.api;

import com.random.ChatRoom.core.chatroom.service.ChatRoomService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatRoomController {

  private final ChatRoomService chatRoomService;

  public ChatRoomController(ChatRoomService chatRoomService) {
    this.chatRoomService = chatRoomService;
  }
}
