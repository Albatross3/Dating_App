package com.random.ChatRoom.core.chat.chatroom.service;

import com.random.ChatRoom.core.chat.chatroom.domain.ChatRoomRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatRoomService {

  private final ChatRoomRepository chatRoomRepository;

  public ChatRoomService(ChatRoomRepository chatRoomRepository) {
    this.chatRoomRepository = chatRoomRepository;
  }

}
