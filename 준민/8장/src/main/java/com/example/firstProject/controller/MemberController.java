package com.example.firstProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    @GetMapping("/signup")
    public String signUpPage(){
        return "members/new";
    }



}
