package com.example.articletest.domain;

import com.example.articletest.config.SHA;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
//getter, setter가 설정되어있어야 post요청으로 받는 데이터를 setting 가능하다.
//@Data사용가능
@Getter
@Setter
public class UserInfo {
    private String user_id;
    private String password;
    private String name;

    private String email;
    private String role=RoleEnum.USER.name();
    private String createBy;
    private Date createAt;

    private String modifiedBy;
    private Date modifiedAt;

    public void setPassword(String pw){
        this.password = SHA.getSHA512(pw);
    }

    public UserInfo(String user_id, String password) {
        this.user_id = user_id;
        this.password = SHA.getSHA512(password);
    }


}
