package com.example.articletest.mapper;

import com.example.articletest.domain.ArticleCommentInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Mapper
public interface ArticleCommentMapper {
    @Results(id="ArticleCommentMapper",value={
            @Result(property = "comment_id",column="id")
    })
    @Select("select * from articleComment where article_id=#{articleid}")

    public List<ArticleCommentInfo> getByArticleId(@Param("articleid") int id);
}
