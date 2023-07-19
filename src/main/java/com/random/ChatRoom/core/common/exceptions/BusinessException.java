package com.random.ChatRoom.core.common.exceptions;

public class BusinessException extends RuntimeException{

  private final ErrorCode errorCode;

  public BusinessException(ErrorCode errorCode) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }
}
