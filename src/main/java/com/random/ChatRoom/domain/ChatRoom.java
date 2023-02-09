package com.random.ChatRoom.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.util.ArrayList;
import java.util.List;


@Getter
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ChatRoom extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long chatRoomId;

    @Column(nullable = false, length = 24)
    private String chatRoomName;

    @Column(nullable = false)
    private int limitedNumberOfPeople;

    @Column
    @Enumerated(EnumType.STRING)
    @ColumnDefault("'NOT_FULL'")
    private RoomStatus roomStatus;

    @OneToMany(mappedBy = "chatRoom")
    private List<ChatMessage> messageList = new ArrayList<>();

    public ChatRoom(String chatRoomName, int limitedNumberOfPeople) {
        this.chatRoomName = chatRoomName;
        this.limitedNumberOfPeople = limitedNumberOfPeople;
    }
}
