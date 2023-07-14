package com.random.ChatRoom.core.chatroom.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ChatType {
  ONE_TO_ONE("1대1 채팅"),
  ONE_TO_MANY("그룹 채팅");

  String typeName;

  ChatType(String typeName) {
    this.typeName = typeName;
  }

  public static List<String> getTypeNameList() {
    return Arrays.stream(ChatType.values())
        .map(type -> type.typeName)
        .collect(Collectors.toList());
  }
}
