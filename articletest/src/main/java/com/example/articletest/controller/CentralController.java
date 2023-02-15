package com.example.articletest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CentralController {
    @GetMapping("")
    public String home(Model model){
        model.addAttribute("data","comehere");
        return "index";
    }

    @GetMapping("/ArticleWrite")
    public String Write(){
        return "ArticleWrite";
    }

    @GetMapping("/SignUp")
    public String SignUp(){
        return "SignUp";
    }
}
