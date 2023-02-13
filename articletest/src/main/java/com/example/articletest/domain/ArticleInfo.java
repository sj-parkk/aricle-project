package com.example.articletest.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleInfo {
    private int id;
    private int user_id;
    private String title;
    private String content;
    private Date createAt;
    private Date modifiedAt;

}
