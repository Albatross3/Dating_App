package com.random.ChatRoom.core.chat.chatroom.dto.response;

import com.random.ChatRoom.core.chat.chatroom.domain.RoomStatus;

public record ChatRoomResponse(Long roomId, String chatRoomName, int limitNumberOfPeople, RoomStatus roomStatus) {

//    public static ChatRoomResponse toChatRoomResponse(ChatRoom chatRoom) {
//        return new ChatRoomResponse(
//                chatRoom.getChatRoomId(),
//                chatRoom.getChatRoomName(),
//                chatRoom.getLimitedNumberOfPeople(),
//                chatRoom.getRoomStatus());
//    }
}
