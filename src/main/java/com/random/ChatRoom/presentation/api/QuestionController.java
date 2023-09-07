package com.random.ChatRoom.presentation.api;

import com.random.ChatRoom.core.common.exceptions.ErrorCode;
import com.random.ChatRoom.core.common.exceptions.InvalidValueException;
import com.random.ChatRoom.core.question.service.QuestionService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class QuestionController {

  private final QuestionService questionService;

  @PostMapping("/question")
  public String createQuestionList(@RequestParam Map<String, String> paramMap) {
    if (paramMap.isEmpty()) {
      throw new InvalidValueException(ErrorCode.QUESTION_EMPTY);
    }
    return "redirect:/start";
  }
}
