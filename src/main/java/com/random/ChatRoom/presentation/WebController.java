package com.random.ChatRoom.presentation;

import com.random.ChatRoom.core.question.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    private final QuestionService questionService;

    public WebController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/question")
    public String viewMainPage(Model model) {
        // TODO 여성 프로필과 함께 질문리스트를 뽑아오는 메서드 필요
        return "question";
    }

    @GetMapping("/start")
    public String viewStartPage() {
        return "start";
    }

    @GetMapping("/mail")
    public String viewMailPage() {
        return "mail";
    }

}
