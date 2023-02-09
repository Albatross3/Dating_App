package com.random.ChatRoom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/main")
    public String viewMainPage() {
        return "main";
    }

    @GetMapping("/start")
    public String viewStartPage() {
        return "start";
    }
}
