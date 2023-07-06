package com.random.ChatRoom.domain.dto.response;

import com.random.ChatRoom.domain.ChatRoom;
import com.random.ChatRoom.domain.RoomStatus;

public record ChatRoomResponse(Long roomId, String chatRoomName, int limitNumberOfPeople, RoomStatus roomStatus) {

    public static ChatRoomResponse toChatRoomResponse(ChatRoom chatRoom) {
        return new ChatRoomResponse(
                chatRoom.getChatRoomId(),
                chatRoom.getChatRoomName(),
                chatRoom.getLimitedNumberOfPeople(),
                chatRoom.getRoomStatus());
    }
}
