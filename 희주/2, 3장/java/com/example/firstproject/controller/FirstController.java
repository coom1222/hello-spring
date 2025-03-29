package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class FirstController {
    @GetMapping("/hi")
    public String niceToMeetYou(Model model) {
        model.addAttribute("username", "heeju");
        return "greetings";
    }

    @GetMapping("/bye")
    public String SeeYouNext(Model model) {
        model.addAttribute("nickname", "희주");
        return "goodbye";
    }
}
