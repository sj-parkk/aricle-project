package com.example.articletest.mapper;



import com.example.articletest.domain.ArticleCommentVO;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Mapper
public interface ArticleCommentMapper {
    @Results(id="ArticleCommentMapper",value={
            @Result(property = "comment_id",column="id")
    })
    @Select("select * from articleComment where article_id=#{articleid} order by id,child_id")
    public List<ArticleCommentVO> getByArticleId(@Param("articleid") int id);


    public void insertArticleComment(@Param("CommentInfo") ArticleCommentVO value);


    void deleteCommentIdAndChild(@Param("CommentInfo") ArticleCommentVO vo);
    void deleteCommentId(@Param("CommentInfo") ArticleCommentVO vo);

    void procedureTest(@Param("ChildInfo")ArticleCommentVO articleCommentVO);
}
