package com.example.articletest.controller;

import com.example.articletest.domain.ArticleInfo;
import com.example.articletest.domain.ArticlesPageVO;
import com.example.articletest.mapper.ArticleMapper;
import com.example.articletest.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.List;

@RestController
@RequestMapping("/Article")
public class ArticleController {
    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    PageService pageService;

    @PostMapping("/insert")
    void insertArticleComments(@RequestBody ArticleInfo articleInfo ){
        articleMapper.makeArticle(articleInfo);
    }

    @GetMapping({"/list","list?pageGroup={pageGroup},next={next}"})
    public ModelAndView getArticles(@RequestParam int pageGroup, @RequestParam int next){
        ModelAndView mav = new ModelAndView();
        List<ArticleInfo> articles = articleMapper.getArticles();
        List<ArticleInfo> PageArticles = pageService.pagingMethod(articles,pageGroup,next);
        int[] pageNum = pageService.returnPageNum();

        mav.setViewName("ArticleList");
        mav.addObject("PageArticle",PageArticles);
        mav.addObject("pageNum",pageNum);
        return mav;
    }

    @GetMapping({"detail","detail?id={id}"})
    public ModelAndView getArticle(@RequestParam int id){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("ArticleDetail");
        mav.addObject("ArticleDetail",articleMapper.getArticle(id));
        return mav;
    }

}
