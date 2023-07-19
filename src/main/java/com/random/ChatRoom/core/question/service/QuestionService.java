package com.random.ChatRoom.core.question.service;

import com.random.ChatRoom.core.question.domain.Question;
import com.random.ChatRoom.core.question.domain.QuestionRepository;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestionService {

  private final QuestionRepository questionRepository;

  public QuestionService(QuestionRepository questionRepository) {
    this.questionRepository = questionRepository;
  }

  @Transactional
  public void createQuestionList(Map<String, String> paramMap) {
    // 비어있는 값은 제거하고 entity 생성
    paramMap.values().stream()
        .filter(s-> !s.isEmpty())
        .forEach(s -> questionRepository.save(new Question(s)));
  }
}
