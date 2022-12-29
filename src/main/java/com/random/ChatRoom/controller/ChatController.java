package com.random.ChatRoom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {




    @GetMapping("/start")
    public String viewStart() {

        return "start";
    }

    @GetMapping("/main")
    public String viewChat() {

        return "main";
    }
}
