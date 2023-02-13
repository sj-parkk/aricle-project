package com.example.articletest.mapper;

import com.example.articletest.domain.ArticleInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Mapper
public interface ArticleMapper {

    @Select("select * from article where user_id=#{user_id}")
    @Results(id="getArticles")
    ArticleInfo giveUserInfo_getArticles();
    @Select("select * from article")
    List<ArticleInfo> getArticles();

    @Insert("insert into article (user_id,title,content,createAt) values(#{Article.user_id},#{Article.title},#{Article.content},sysdate())")
    int makeArticle(@Param("Article") ArticleInfo articleInfo);

    @GetMapping("/{id}")
    @Select("select * from article where id=#{ArticleNum}")
    ArticleInfo getArticle(@Param("ArticleNum")int ArticleNum);


}
