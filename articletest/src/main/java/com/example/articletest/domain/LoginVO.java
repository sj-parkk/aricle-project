package com.example.articletest.domain;

import com.example.articletest.config.SHA;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginVO {
    private String user_id;
    private String password;
    public void setPassword(String pw){
        this.password = pw;
    }
}
