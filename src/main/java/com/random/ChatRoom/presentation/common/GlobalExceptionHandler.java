package com.random.ChatRoom.presentation.common;

import com.random.ChatRoom.core.common.exceptions.BusinessException;
import com.random.ChatRoom.core.common.exceptions.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException e) {
    ErrorCode errorCode = e.getErrorCode();
    ErrorResponse errorResponse = new ErrorResponse(errorCode);
    return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorCode.getStatus()));
  }

}
