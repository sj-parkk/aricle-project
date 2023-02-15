package com.example.articletest.controller;

import com.example.articletest.domain.ArticleCommentInfo;
import com.example.articletest.mapper.ArticleCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/ArticleComment")
public class ArticleCommentController {
    @Autowired
    ArticleCommentMapper articleCommentMapper;

    @GetMapping("/{id}")
    public List<ArticleCommentInfo> getByArticleId(@PathVariable int id){return articleCommentMapper.getByArticleId(id);}

    @PostMapping("/insert")
    ModelAndView insertArticleComments(@RequestBody ArticleCommentInfo articleCommentInfo ){
        articleCommentMapper.insertArticleComment(articleCommentInfo);
        ModelAndView modelAndView = new ModelAndView();
        //다른컨트롤러 이동할때는 viewName 셋팅하는 쪽에 redirect: 붙여주자
        modelAndView.setViewName("redirect:/Article/detail?id="+articleCommentInfo.getArticle_id());
        return modelAndView;
    }
}
