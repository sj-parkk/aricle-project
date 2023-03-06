package com.example.articletest.domain;

import com.example.articletest.config.SHA;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class UserInfo {
    private String user_id;
    private String password;
    private String name;

    private String email;
    private String role=RoleEnum.USER.name();
//    private String authentic_num;
    private String createBy;
    private Date createAt;

    private String modifiedBy;
    private Date modifiedAt;


    public UserInfo(String user_id, String password) {
        this.user_id = user_id;
        this.password = password;
    }


}
