package com.random.ChatRoom.presentation.api;

import com.random.ChatRoom.core.member.dto.MemberRegisterRequest;
import com.random.ChatRoom.core.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @PostMapping("/register")
  public String createMember(@RequestBody MemberRegisterRequest memberRegisterRequest) {
    memberService.saveMember(memberRegisterRequest);
    return "redirect:/start";
  }

}
