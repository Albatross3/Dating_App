package com.random.ChatRoom.core.chat.chatroom.domain;

import com.random.ChatRoom.core.chat.chatmessage.domain.ChatMessage;
import com.random.ChatRoom.core.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;


@Getter
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ChatRoom extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long chatRoomId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ChatType chatType;

    @Column(nullable = false, length = 24)
    private String chatRoomName;

    @OneToMany(mappedBy = "chatRoom")
    private List<ChatMessage> messageList = new ArrayList<>();

    public ChatRoom(ChatType chatType, String chatRoomName) {
        this.chatType = chatType;
        this.chatRoomName = chatRoomName;
    }
}
