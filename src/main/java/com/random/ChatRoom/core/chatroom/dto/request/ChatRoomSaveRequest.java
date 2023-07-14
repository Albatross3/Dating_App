package com.random.ChatRoom.core.chatroom.dto.request;

import com.random.ChatRoom.core.chatroom.domain.ChatRoom;

public record ChatRoomSaveRequest(String roomName, int limitedNumberOfPeople) {

//  public static ChatRoom toChatRoom(ChatRoomSaveRequest chatRoomSaveRequest) {
//    return new ChatRoom(chatRoomSaveRequest.roomName(), chatRoomSaveRequest.limitedNumberOfPeople());
//  }

}

