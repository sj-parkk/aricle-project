package com.example.articletest.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ArticleInfo {
    private int article_id;
    private String user_id;
    private int pageNum;
    private int pageGroup;
    private int maxPageGroup;
    private String title;
    private String content;
    private List<ArticleCommentInfo> articleCommentList;
    private Date createAt;
    private Date modifiedAt;



}
