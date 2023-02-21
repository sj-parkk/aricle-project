package com.example.articletest.mapper;

import com.example.articletest.domain.ArticleCommentInfo;
import com.example.articletest.domain.ArticleCommentVO;
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

// 무슨 이유인지는 잘 모르겠지만 user_id not found 에러가 계속 떴었는데 아마도 @Param으로 설정한 이름과 articlecomment.xml에서 파라미터 이름 붙이는거랑 같아야하는듯
    public void insertArticleComment(@Param("CommentInfo") ArticleCommentVO value);
}
