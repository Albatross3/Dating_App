package com.random.ChatRoom.global.email.exceptions;

import com.random.ChatRoom.core.common.exceptions.BusinessException;
import com.random.ChatRoom.core.common.exceptions.ErrorCode;

public class EmailCreationFailedException extends BusinessException {

  public EmailCreationFailedException(ErrorCode errorCode) {
    super(errorCode);
  }
}
