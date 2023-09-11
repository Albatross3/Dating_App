package com.random.ChatRoom.global.exception;

import com.random.ChatRoom.core.common.exceptions.BusinessException;
import com.random.ChatRoom.core.common.exceptions.ErrorCode;

public class VerificationCodeExpiredException extends BusinessException {

  public VerificationCodeExpiredException(
      ErrorCode errorCode) {
    super(errorCode);
  }
}
