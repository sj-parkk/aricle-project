package com.example.articletest.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleCommentVO {
    private long id;
    private long article_id;
    private long child_id;
    private String comment;
    private String user_id;
}
