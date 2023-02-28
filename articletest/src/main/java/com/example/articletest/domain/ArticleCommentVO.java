package com.example.articletest.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ArticleCommentVO {
    private long comment_id;
    private long article_id;
    private long child_id;
    private String comment;
    private String user_id;
    private Date createAt;

    public ArticleCommentVO(long comment_id, long child_id) {
        this.comment_id = comment_id;
        this.child_id = child_id;
    }
}
