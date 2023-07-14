package com.random.ChatRoom.presentation;

import com.random.ChatRoom.core.chatroom.domain.ChatType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/main")
    public String viewMainPage() {
        return "main";
    }

    @GetMapping("/start")
    public String viewStartPage(Model model) {
        // Map<String, ?> 으로 model 값을 넣어줄 수 있다
        model.addAttribute("chat_types", ChatType.getTypeNameList());
        return "start";
    }
}
