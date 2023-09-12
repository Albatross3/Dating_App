package com.random.ChatRoom.core.member.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.random.ChatRoom.core.member.domain.Major;
import com.random.ChatRoom.core.member.domain.Member;
import com.random.ChatRoom.core.member.domain.MemberRepository;
import com.random.ChatRoom.core.member.domain.Sex;
import com.random.ChatRoom.core.member.dto.MemberRegisterRequest;
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
    MemberRegisterRequest memberRegisterRequest =
        new MemberRegisterRequest("user123@seoultech.ac.kr", "password123", Sex.MALE, "LEE", 27,
            Major.INDUSTRIAL_ENGINEERING);

    // when
    Member savedMember = Member.builder()
        .memberId(1L)
        .email("user123@seoultech.ac.kr")
        .password("password123")
        .sex(Sex.MALE)
        .nickname("LEE")
        .age(27)
        .major(Major.INDUSTRIAL_ENGINEERING)
        .build();

    when(memberRepository.save(any()))
        .thenReturn(savedMember);

    Long memberId = memberService.saveMember(memberRegisterRequest);

    // then
    Assertions.assertThat(memberId).isEqualTo(1L);
  }

}