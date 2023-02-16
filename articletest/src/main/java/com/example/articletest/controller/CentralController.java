package com.example.articletest.controller;

import com.example.articletest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CentralController {
    @Autowired UserMapper mapper;
    @GetMapping("")
    public String home(Model model){
        model.addAttribute("data","comehere");
        return "Article";
    }

    @GetMapping("/ArticleWrite")
    public String Write(){
        return "ArticleWrite";
    }

    @GetMapping("/SignUp")
    public String SignUp(){
        return "SignUp";
    }

    @GetMapping("/LoginForm")
    public String LoginForm(){
        return "LoginForm";
    }

    @GetMapping("/Admin")
    public String AdminForm(Model model){
        model.addAttribute("UserList",mapper.getAll());
        return "Admin";
    }


}
