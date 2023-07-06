package com.random.ChatRoom.service;

import com.random.ChatRoom.domain.ChatRoom;
import com.random.ChatRoom.domain.dto.request.ChatRoomSaveRequest;
import com.random.ChatRoom.domain.dto.response.ChatRoomListResponse;
import com.random.ChatRoom.domain.dto.response.ChatRoomResponse;
import com.random.ChatRoom.domain.dto.response.ChatRoomSaveResponse;
import com.random.ChatRoom.repository.ChatRoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

  @Transactional
  public ChatRoomListResponse findChatRoomList() {
    List<ChatRoom> allChatRoom = chatRoomRepository.findAll();
    List<ChatRoomResponse> chatRoomResponseList = allChatRoom.stream()
            .map(ChatRoomResponse::toChatRoomResponse)
            .collect(Collectors.toList());
    return new ChatRoomListResponse(chatRoomResponseList);
  }
}
