package com.random.ChatRoom.domain.dto.request;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ChatMessageRequest {
    private Long roomId;
    private String sender;
    private String message;
    private LocalDateTime createdAt;

    public ChatMessageRequest(Long roomId, String sender, String message) {
        this.roomId = roomId;
        this.sender = sender;
        this.message = message;
        this.createdAt = LocalDateTime.now();
    }
}
