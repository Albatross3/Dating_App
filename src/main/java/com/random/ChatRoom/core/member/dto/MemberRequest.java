package com.random.ChatRoom.core.member.dto;

import com.random.ChatRoom.core.member.domain.Major;
import com.random.ChatRoom.core.member.domain.Member;
import com.random.ChatRoom.core.member.domain.Sex;

public record MemberRequest(Sex sex, String nickname, int age, Major major) {

  public Member toMember() {
    return Member.builder()
        .sex(sex)
        .nickname(nickname)
        .age(age)
        .major(major)
        .build();
  }

}
