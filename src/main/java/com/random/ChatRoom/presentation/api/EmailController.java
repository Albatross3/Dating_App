package com.random.ChatRoom.presentation.api;

import com.random.ChatRoom.global.email.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {

  private final EmailService emailService;

  @PostMapping("/email/{email}")
  public void createVerificationCode(@PathVariable("email") String email) {
    emailService.sendEmailForRegister(email);
  }
}
