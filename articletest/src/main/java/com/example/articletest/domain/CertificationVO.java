package com.example.articletest.domain;

import com.example.articletest.service.CertificationSerivce;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class CertificationVO {
    private String user_id;
    private String cert = CertificationSerivce.generateAuthNo();
    private String email;
    private String admin_email="game3408@naver.com";


}
