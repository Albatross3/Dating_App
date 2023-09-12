package com.random.ChatRoom.core.member.dto;

import com.random.ChatRoom.core.member.domain.Major;
import com.random.ChatRoom.core.member.domain.Member;
import com.random.ChatRoom.core.member.domain.Sex;

public record MemberRegisterRequest(String email, String password, Sex sex, String nickname, int age, Major major) {

  public Member toMember() {
    return Member.builder()
        .email(email)
        .password(password)
        .sex(sex)
        .nickname(nickname)
        .age(age)
        .major(major)
        .build();
  }

}
