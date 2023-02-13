package com.example.articletest.controller;

import com.example.articletest.domain.ArticleInfo;
import com.example.articletest.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Article")
public class ArticleController {
    @Autowired
    ArticleMapper articleMapper;

    @PostMapping("")
    public int makeArticle(@RequestBody ArticleInfo articleInfo){return articleMapper.makeArticle(articleInfo); }
    @GetMapping("")
    public List<ArticleInfo> getArticles(){return articleMapper.getArticles();}

    @GetMapping("/{id}")
    public ArticleInfo getArticle(@PathVariable int id){return articleMapper.getArticle(id);}


}
