package com.random.ChatRoom.core.chatroom.dto.response;

import com.random.ChatRoom.core.chatroom.domain.ChatRoom;
import com.random.ChatRoom.core.chatroom.domain.RoomStatus;

public record ChatRoomSaveResponse(String roomName, int limitedNumberOfPeople, RoomStatus roomStatus) {

//    public static ChatRoomSaveResponse fromChatRoom(ChatRoom chatRoom) {
//        return new ChatRoomSaveResponse(chatRoom.getChatRoomName(), chatRoom.getLimitedNumberOfPeople(), RoomStatus.NOT_FULL);
//    }

}
