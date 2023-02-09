package com.random.ChatRoom.domain.dto.request;

import com.random.ChatRoom.domain.ChatRoom;

public record ChatRoomSaveRequest(String roomName, int limitedNumberOfPeople) {

  public static ChatRoom toChatRoom(ChatRoomSaveRequest chatRoomSaveRequest) {
    return new ChatRoom(chatRoomSaveRequest.roomName, chatRoomSaveRequest.limitedNumberOfPeople());
  }

}
