package com.random.ChatRoom.presentation.api;

import com.random.ChatRoom.core.member.dto.MemberRequest;
import com.random.ChatRoom.core.member.service.MemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class MemberController {

  private final MemberService memberService;

  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @PostMapping("/member")
  public String createMember(@RequestBody MemberRequest memberRequest) {
    memberService.saveMember(memberRequest);
    return "redirect:/start";
  }
}
