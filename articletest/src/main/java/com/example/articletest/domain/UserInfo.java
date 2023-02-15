package com.example.articletest.domain;

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
    private String createBy;
    private Date createAt;

    private String modifiedBy;
    private Date modifiedAt;

}
