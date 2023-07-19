package com.random.ChatRoom.core.common.exceptions;

import lombok.Getter;

@Getter
public enum ErrorCode {

  QUESTION_EMPTY(400, "질문이 비어있습니다");

  private final int status;
  private final String message;

  ErrorCode(int status, String message) {
    this.status = status;
    this.message = message;
  }
}
