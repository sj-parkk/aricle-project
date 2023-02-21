package com.example.articletest.domain;

//import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ArticleCommentInfo {
    private long comment_id;
    private long article_id;
    private String user_id;
    private String comment;

    private Date createAt;
}
