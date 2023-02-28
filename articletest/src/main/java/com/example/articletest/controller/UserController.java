package com.example.articletest.controller;

import com.example.articletest.config.SHA;
import com.example.articletest.domain.RoleEnum;
import com.example.articletest.domain.UserInfo;
import com.example.articletest.mapper.UserMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

// User로 들어오는 요청은 여기서 처리된다.
@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserMapper userMapper;


    @GetMapping("")
    public List<UserInfo> getUserListAll(){
        return userMapper.getAll();
    }



    @PostMapping("/update")
    public void updateUserInfo(@RequestBody UserInfo userInfo){
        userInfo.setPassword(userInfo.getPassword());
        userMapper.updateAccount(userInfo);
    }

    @PostMapping("/SignUp")
    public void insertUserInfo(@RequestBody UserInfo userInfo) {

        userInfo.setPassword(userInfo.getPassword());
        userInfo.setRole(userInfo.getRole());
        userMapper.insertAccount(userInfo);
    }

    @GetMapping("/MyInfo")
    public ModelAndView myInfo(String id){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("MyInfo");
        return mav;
    }



}
