package com.random.ChatRoom.core.member.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@DataJpaTest
class MemberRepositoryTest {

  @Autowired
  MemberRepository memberRepository;

  @Test
  @DisplayName("멤버 저장 테스트")
  public void memberSaveTest() {
    Member member = Member.builder()
        .sex(Sex.MALE)
        .age(27)
        .nickname("Albatross")
        .major(Major.INDUSTRIAL_ENGINEERING)
        .build();

    Member savedMember = memberRepository.save(member);

    assertThat(savedMember).usingRecursiveComparison().isEqualTo(member);
  }

  @Test
  @DisplayName("멤버 전체 조회 테스트")
  public void memberFindAllTest() {
    Member maleMember = Member.builder()
        .sex(Sex.MALE)
        .age(27)
        .nickname("Albatross")
        .major(Major.INDUSTRIAL_ENGINEERING)
        .build();

    Member femaleMember = Member.builder()
        .sex(Sex.FEMALE)
        .age(24)
        .nickname("NAMURL")
        .major(Major.CREATIVE_WRITING)
        .build();

    memberRepository.save(maleMember);
    memberRepository.save(femaleMember);

    List<Member> allMember = memberRepository.findAll();

    assertThat(allMember.size()).isEqualTo(2);
  }

  @Test
  @DisplayName("멤버 fetch join test")
  public void memberFetchJoinTest() {
    // TODO N+1 문제를 해결하기 위한 FetchJoin or BatchSize 방식에 대한 test
  }

}