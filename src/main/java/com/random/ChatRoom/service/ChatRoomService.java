package com.random.ChatRoom.service;

import com.random.ChatRoom.domain.ChatRoom;
import com.random.ChatRoom.domain.dto.request.ChatRoomSaveRequest;
import com.random.ChatRoom.domain.dto.response.ChatRoomSaveResponse;
import com.random.ChatRoom.repository.ChatRoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChatRoomService {

  private final ChatRoomRepository chatRoomRepository;

  public ChatRoomService(ChatRoomRepository chatRoomRepository) {
    this.chatRoomRepository = chatRoomRepository;
  }

  @Transactional
  public ChatRoomSaveResponse saveChatRoom(ChatRoomSaveRequest chatRoomSaveRequest) {
    ChatRoom chatRoom = ChatRoomSaveRequest.toChatRoom(chatRoomSaveRequest);
    // 영속화된 엔티티를 return 한다
    ChatRoom savedChatRoom = chatRoomRepository.save(chatRoom);
    return ChatRoomSaveResponse.fromChatRoom(savedChatRoom);
  }
}
