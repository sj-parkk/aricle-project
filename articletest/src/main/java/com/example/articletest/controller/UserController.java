package com.example.articletest.controller;

import com.example.articletest.domain.UserInfo;
import com.example.articletest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// User로 들어오는 요청은 여기서 처리된다.
@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @PostMapping("")
    public int post(@RequestBody UserInfo user){
        return userMapper.insert(user);
    }

    @GetMapping("")
    public List<UserInfo> getAll(){
        return userMapper.getAll();
    }

    @GetMapping("/{id}")
    public UserInfo giveId_getUserInfo(@PathVariable int id){
        return userMapper.giveId_getUserInfo(id);
    }
}
