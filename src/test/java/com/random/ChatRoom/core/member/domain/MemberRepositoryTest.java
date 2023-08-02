package com.random.ChatRoom.core.member.domain;

import com.random.ChatRoom.core.question.domain.Question;
import com.random.ChatRoom.core.question.domain.QuestionRepository;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class MemberRepositoryTest {

  @Autowired
  MemberRepository memberRepository;

  @Autowired
  QuestionRepository questionRepository;

  @BeforeEach
  public void ready() {
    Member member = Member.builder()
        .sex(Sex.FEMALE)
        .age(24)
        .nickname("NAMURL")
        .major(Major.COMPUTER_SCIENCE)
        .build();

    Question question1 = Question.builder()
        .question("이상형은 누구인가요?")
        .member(member)
        .build();

    Question question2 = Question.builder()
        .question("이성 친구는 몇명인가요?")
        .member(member)
        .build();

    memberRepository.save(member);
    questionRepository.save(question1);
    questionRepository.save(question2);

  }

  @Test
  public void memberTest() {

    // member 를 통해서 team 객체를 불러올 때 FetchType.LAZY 를 적용하면 team proxy 객체가 온다
    // team 객체에 대한 조회가 필요한 경우에 실제 객체가 들어오게 된다
    // 즉 다에서 1을 불러올 때 @ManyToOne 에 적용할 수 있는 것

    // 내가 궁금한건 1에서 다를 불러올때는 어떻게 해야하는지?

    List<Member> allMember = memberRepository.findAll();
    Assertions.assertThat(allMember.size()).isEqualTo(1);

    System.out.println("나오는 것이냐?");
    Member member = allMember.get(0);
    List<Question> memberList = member.getQuestions();
    System.out.println(memberList.size());

    for (Question q : memberList) {
      System.out.println(q.getQuestion());
    }

  }

}