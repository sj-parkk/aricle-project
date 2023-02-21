package com.example.articletest.controller;

import com.example.articletest.domain.ArticleInfo;
import com.example.articletest.domain.ArticlesPageVO;
import com.example.articletest.mapper.ArticleMapper;
import com.example.articletest.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/Article")
public class ArticleController {
    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    PageService pageService;

    @PostMapping("")
    public void makeArticle(@RequestBody ArticleInfo articleInfo){

    }
    @GetMapping({"/list","list?pageGroup={pageGroup}"})
    public ModelAndView getArticles(@RequestParam int pageGroup){
        ModelAndView mav = new ModelAndView();

        List<ArticleInfo> PageArticles = pageService.pagingMethod(articleMapper.getArticles(),pageGroup);

        mav.setViewName("ArticleList");
        mav.addObject("PageArticle",PageArticles);

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
