package com.random.ChatRoom.core.chat.chatroom.dto.request;

public record ChatRoomSaveRequest(String roomName, int limitedNumberOfPeople) {

//  public static ChatRoom toChatRoom(ChatRoomSaveRequest chatRoomSaveRequest) {
//    return new ChatRoom(chatRoomSaveRequest.roomName(), chatRoomSaveRequest.limitedNumberOfPeople());
//  }

}

