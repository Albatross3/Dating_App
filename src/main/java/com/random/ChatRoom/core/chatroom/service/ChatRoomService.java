package com.random.ChatRoom.core.chatroom.service;

import com.random.ChatRoom.core.chatroom.domain.ChatRoom;
import com.random.ChatRoom.core.chatroom.dto.request.ChatRoomSaveRequest;
import com.random.ChatRoom.core.chatroom.dto.response.ChatRoomListResponse;
import com.random.ChatRoom.core.chatroom.dto.response.ChatRoomResponse;
import com.random.ChatRoom.core.chatroom.dto.response.ChatRoomSaveResponse;
import com.random.ChatRoom.core.chatroom.domain.ChatRoomRepository;
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

//  @Transactional
//  public ChatRoomSaveResponse saveChatRoom(ChatRoomSaveRequest chatRoomSaveRequest) {
//    ChatRoom chatRoom = ChatRoomSaveRequest.toChatRoom(chatRoomSaveRequest);
//    // 영속화된 엔티티를 return 한다
//    ChatRoom savedChatRoom = chatRoomRepository.save(chatRoom);
//    return ChatRoomSaveResponse.fromChatRoom(savedChatRoom);
//  }
//
//  @Transactional
//  public ChatRoomListResponse findChatRoomList() {
//    List<ChatRoom> allChatRoom = chatRoomRepository.findAll();
//    List<ChatRoomResponse> chatRoomResponseList = allChatRoom.stream()
//            .map(ChatRoomResponse::toChatRoomResponse)
//            .collect(Collectors.toList());
//    return new ChatRoomListResponse(chatRoomResponseList);
//  }
}
