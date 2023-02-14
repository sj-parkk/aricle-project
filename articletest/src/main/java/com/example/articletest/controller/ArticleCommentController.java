package com.example.articletest.controller;

import com.example.articletest.domain.ArticleCommentInfo;
import com.example.articletest.mapper.ArticleCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ArticleComment")
public class ArticleCommentController {
    @Autowired
    ArticleCommentMapper articleCommentMapper;

    @GetMapping("/{id}")
    public List<ArticleCommentInfo> getByArticleId(@PathVariable int id){return articleCommentMapper.getByArticleId(id);}
}
