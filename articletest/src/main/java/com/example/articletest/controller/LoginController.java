package com.example.articletest.controller;

import com.example.articletest.domain.LoginVO;
import com.example.articletest.domain.UserInfo;
import com.example.articletest.mapper.SessionContants;
import com.example.articletest.mapper.UserMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired UserMapper userMapper;

    @PostMapping("/login")
    public String login(LoginVO loginVO, HttpServletRequest request, RedirectAttributes rttr){
        HttpSession session = request.getSession();
        UserInfo userInfo = userMapper.getUserById(loginVO.getUserid());
        if(userInfo==null){
            rttr.addFlashAttribute("loginFail","로그인 실패!");
            return "/LoginForm";
        }
        session.setAttribute(SessionContants.Login_Member,userInfo);

        return "redirect:/Article/list?pageGroup=1";
    }

    @GetMapping("/LogOut")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("loginMember");
        return "redirect:/LoginForm";
    }
}
