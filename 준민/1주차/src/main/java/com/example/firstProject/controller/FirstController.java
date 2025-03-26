package com.example.firstProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String niceToMeetYou(Model model) {  // 모델 객체 받아오기
        // model.addAttribute("변수명", "변수값");
        model.addAttribute("username", "junmin");   // addAtribute 메소드로 모델 객체에 데이터를 담아서 뷰로 전달
        return "greetings";
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model) {
        model.addAttribute("nickname", "뽀로로");
        return "goodbye";
    }
}
