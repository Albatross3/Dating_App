package com.random.ChatRoom.core.member.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long memberId;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Sex sex;

  @Column(unique = true)
  private String nickname;

  @Column(nullable = false)
  private Integer age;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Major major;

  public Member(Sex sex, String nickname, Integer age, Major major) {
    this.sex = sex;
    this.nickname = nickname;
    this.age = age;
    this.major = major;
  }

  public Member(Long memberId, Sex sex, String nickname, Integer age, Major major) {
    this.memberId = memberId;
    this.sex = sex;
    this.nickname = nickname;
    this.age = age;
    this.major = major;
  }
}
