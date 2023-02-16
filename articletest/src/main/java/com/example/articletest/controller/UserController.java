package com.example.articletest.controller;

import com.example.articletest.domain.RoleEnum;
import com.example.articletest.domain.UserInfo;
import com.example.articletest.mapper.UserMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

// User로 들어오는 요청은 여기서 처리된다.
@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("")
    public int post(@RequestBody UserInfo user){
        return userMapper.insert(user);
    }

    @GetMapping("")
    public List<UserInfo> getAll(){
        return userMapper.getAll();
    }

    @GetMapping("/{id}")
    public UserInfo getUserById(@PathVariable String id){
//        return userMapper.giveId_getUserInfo(id);
        return userMapper.getUserById(id);
    }

    @PostMapping("/update")
    public void updateUserInfo(@RequestBody UserInfo userInfo){
        userMapper.updateAccount(userInfo);
    }

    @PostMapping("/SignUp")
    public void insertUserInfo(@RequestBody UserInfo userInfo) {
        String rawPassword = userInfo.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        userInfo.setPassword(encPassword);
        userInfo.setRole(userInfo.getRole());
        userMapper.insertAccount(userInfo);
    }



}
