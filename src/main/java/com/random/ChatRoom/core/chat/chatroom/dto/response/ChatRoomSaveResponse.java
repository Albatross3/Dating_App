package com.random.ChatRoom.core.chat.chatroom.dto.response;

import com.random.ChatRoom.core.chat.chatroom.domain.RoomStatus;

public record ChatRoomSaveResponse(String roomName, int limitedNumberOfPeople, RoomStatus roomStatus) {

//    public static ChatRoomSaveResponse fromChatRoom(ChatRoom chatRoom) {
//        return new ChatRoomSaveResponse(chatRoom.getChatRoomName(), chatRoom.getLimitedNumberOfPeople(), RoomStatus.NOT_FULL);
//    }

}
