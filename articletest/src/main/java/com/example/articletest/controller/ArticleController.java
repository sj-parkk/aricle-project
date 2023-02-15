package com.example.articletest.controller;

import com.example.articletest.domain.ArticleCommentInfo;
import com.example.articletest.domain.ArticleInfo;
import com.example.articletest.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/Article")
public class ArticleController {
    @Autowired
    ArticleMapper articleMapper;

    @PostMapping("")
    public void makeArticle(@RequestBody ArticleInfo articleInfo){

    }
    @GetMapping("")
    public ModelAndView getArticles(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Articlelist");
        mav.addObject("Articles",articleMapper.getArticles());
        return mav;
    }

    @GetMapping({"detail","detail?id={id}"})
    public ModelAndView getArticle(@RequestParam int id){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("ArticleDetail");
        mav.addObject("ArticleDetail",articleMapper.getArticle(id));
        return mav;
    }

    @PostMapping("/insert")
    void insertArticleComments(@RequestBody ArticleInfo articleInfo ){
        articleMapper.makeArticle(articleInfo);
    }





}
