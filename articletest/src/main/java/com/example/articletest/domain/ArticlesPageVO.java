package com.example.articletest.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter @Setter
public class ArticlesPageVO {

    private List<ArticleInfo> articleInfo;

    public ArticlesPageVO(List<ArticleInfo> articleInfo) {

        this.articleInfo = articleInfo;
    }

    public static ArticlesPageVO of(List<ArticleInfo> articleInfo) {
        return new ArticlesPageVO(articleInfo);
    }
}
