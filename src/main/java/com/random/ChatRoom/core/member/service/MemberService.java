package com.random.ChatRoom.core.member.service;

import com.random.ChatRoom.core.member.domain.Member;
import com.random.ChatRoom.core.member.domain.MemberRepository;
import com.random.ChatRoom.core.member.dto.MemberRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

  private final MemberRepository memberRepository;

  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Transactional
  public void saveMember(MemberRequest memberRequest) {
    Member member = memberRequest.toMember();
    memberRepository.save(member);
  }
}
