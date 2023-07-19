package com.random.ChatRoom.core.common.exceptions;

public class InvalidValueException extends BusinessException{

  public InvalidValueException(ErrorCode errorCode) {
    super(errorCode);
  }
}
