package com.random.ChatRoom.domain.dto.response;

import com.random.ChatRoom.domain.ChatRoom;
import com.random.ChatRoom.domain.RoomStatus;

public record ChatRoomSaveResponse(String roomName, int limitedNumberOfPeople, RoomStatus roomStatus) {

    public static ChatRoomSaveResponse fromChatRoom(ChatRoom chatRoom) {
        return new ChatRoomSaveResponse(chatRoom.getChatRoomName(), chatRoom.getLimitedNumberOfPeople(), RoomStatus.NOT_FULL);
    }

}
