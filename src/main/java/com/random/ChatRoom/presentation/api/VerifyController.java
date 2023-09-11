package com.random.ChatRoom.presentation.api;

import com.random.ChatRoom.global.email.dto.request.EmailVerifyRequest;
import com.random.ChatRoom.global.email.dto.response.EmailVerifyResponse;
import com.random.ChatRoom.global.utils.VerificationCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VerifyController {

  private final VerificationCodeService verificationCodeService;

  @PostMapping("/code")
  public ResponseEntity<EmailVerifyResponse> verifyEmail(@RequestBody EmailVerifyRequest emailVerifyRequest) {
    boolean isEqual = verificationCodeService.checkVerificationCodeAlive(emailVerifyRequest.toEmail(),
        emailVerifyRequest.verificationCode());
    return ResponseEntity.ok(new EmailVerifyResponse(isEqual));
  }

}
