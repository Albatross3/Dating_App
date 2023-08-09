package com.random.ChatRoom.core.question.service;

import com.random.ChatRoom.core.question.domain.QuestionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@Service
public class QuestionService {

  private final QuestionRepository questionRepository;

}
