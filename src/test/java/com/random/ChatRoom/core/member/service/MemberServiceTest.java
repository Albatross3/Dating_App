package com.random.ChatRoom.core.member.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.random.ChatRoom.core.member.domain.Major;
import com.random.ChatRoom.core.member.domain.Member;
import com.random.ChatRoom.core.member.domain.MemberRepository;
import com.random.ChatRoom.core.member.domain.Sex;
import com.random.ChatRoom.core.member.dto.MemberRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

  MemberService memberService;

  @Mock
  MemberRepository memberRepository;

  @Test
  public void memberSaveTest() {
    // given
    memberService = new MemberService(memberRepository);
    MemberRequest memberRequest =
        new MemberRequest(Sex.MALE, "LEE", 27, Major.INDUSTRIAL_ENGINEERING);

    // when
    when(memberRepository.save(any()))
        .thenReturn(new Member(1L,  Sex.MALE, "LEE", 27, Major.INDUSTRIAL_ENGINEERING));

    Long memberId = memberService.saveMember(memberRequest);

    // then
    Assertions.assertThat(memberId).isEqualTo(1L);
  }

}