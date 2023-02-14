package com.example.articletest.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ArticleInfo {
    private int article_id;
    private int user_id;
    private String title;
    private String content;
    private List<ArticleCommentInfo> articleCommentList;
    private Date createAt;
    private Date modifiedAt;

}
