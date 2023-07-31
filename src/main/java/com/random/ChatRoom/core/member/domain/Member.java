package com.random.ChatRoom.core.member.domain;


import com.random.ChatRoom.core.question.domain.Question;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
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
  private int age;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Major major;

  @OneToMany(mappedBy = "member")
  private List<Question> questions = new ArrayList<>();

  @Builder
  public Member(Long memberId, Sex sex, String nickname, int age, Major major) {
    this.memberId = memberId;
    this.sex = sex;
    this.nickname = nickname;
    this.age = age;
    this.major = major;
  }

}
