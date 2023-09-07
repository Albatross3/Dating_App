package com.random.ChatRoom.core.common.exceptions;

import lombok.Getter;

@Getter
public enum ErrorCode {

  QUESTION_EMPTY(400, "질문이 비어있습니다"),

  EMAIL_CREATION_FAILED(500,"메일 생성에 실패하였습니다"),
  EMAIL_SEND_FAILED(500,"메일 전송에 실패하였습니다");



  private final int status;
  private final String message;

  ErrorCode(int status, String message) {
    this.status = status;
    this.message = message;
  }
}
