package com.random.ChatRoom.global.email.exceptions;

import com.random.ChatRoom.core.common.exceptions.BusinessException;
import com.random.ChatRoom.core.common.exceptions.ErrorCode;

public class EmailSendFailedException extends BusinessException {

  public EmailSendFailedException(ErrorCode errorCode) {
    super(errorCode);
  }
}
