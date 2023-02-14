package com.example.articletest.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleCommentInfo {
    private long comment_id;
    private long article_id;
    private long user_id;
    private String comment;
    private Date createAt;
}
