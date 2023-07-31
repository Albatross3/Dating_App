package com.random.ChatRoom.core.question.domain;

import com.random.ChatRoom.core.member.domain.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Question {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long questionId;

  @Column(nullable = false)
  private String question;

  @ManyToOne
  @JoinColumn(name = "member_id")
  private Member member;

  @Builder
  public Question(String question, Member member) {
    this.question = question;
    this.member = member;
  }
}
