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

    //서브쿼리를 사용해서 articleCommentList를 넣어줌
    @Select("select * from article order by createAt")
    @Results(id="articleMap", value= {
            @Result(property = "article_id", column = "id"),
            @Result(property = "articleCommentList",column="id",many=@Many(select="com.example.articletest.mapper.ArticleCommentMapper.getByArticleId"))
    }
    )
    List<ArticleInfo> getArticles();

    @Insert("insert into article (user_id,title,content,createAt) values(#{Article.user_id},#{Article.title},#{Article.content},sysdate())")
    void makeArticle(@Param("Article") ArticleInfo articleInfo);

    @GetMapping("/{id}")
    @ResultMap("articleMap")
    @Select("select * from article where id=#{ArticleNum}")
    ArticleInfo getArticle(@Param("ArticleNum")int ArticleNum);

}
