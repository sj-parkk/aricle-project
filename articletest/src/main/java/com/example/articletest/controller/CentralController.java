package com.example.articletest.controller;

import com.example.articletest.domain.RoleEnum;
import com.example.articletest.domain.UserInfo;
import com.example.articletest.mapper.UserMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CentralController {
    @Autowired UserMapper mapper;
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

    @GetMapping("/LoginForm")
    public String LoginForm(){
        return "LoginForm";
    }

    @GetMapping("/Admin")
    public String AdminForm(Model model, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session == null){
            return "redirect:/Article/list?pageGroup=1";
        }
        UserInfo userInfo = (UserInfo) session.getAttribute("loginMember");
        String role = userInfo.getRole();
        if(
                role == null ||
                role.length() == 0 ||
                role.equals(RoleEnum.USER.name())
        )
        {
            return "redirect:/Article/list?pageGroup=1";
        }
        session.getAttribute("loginMember");
        model.addAttribute("UserList",mapper.getAll());

        return "Admin";
    }
    @GetMapping("/alert")
    public String alertForm(){
        return "alert";
    }


}
