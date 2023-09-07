package com.random.ChatRoom.presentation.api;

import com.random.ChatRoom.core.member.dto.MemberRegisterRequest;
import com.random.ChatRoom.core.member.service.MemberService;
import com.random.ChatRoom.global.email.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;
  private final EmailService emailService;

  @PostMapping("/email/{email}")
  public void createVerificationCode(@PathVariable("email") String email) {
    emailService.sendEmailForRegister(email);
  }

  @PostMapping("/register")
  public String createMember(@RequestBody MemberRegisterRequest memberRegisterRequest) {
    memberService.saveMember(memberRegisterRequest);
    return "redirect:/start";
  }

}
