package com.example.articletest.service;

import com.example.articletest.domain.ArticleInfo;

import com.example.articletest.domain.ArticlesPageVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PageService {



    public List<ArticleInfo> pagingMethod(List<ArticleInfo> articles,int GetpageGroup){

        int pageGroup = 0;

        for(int i=0;i<articles.size();i++){

            if(i%5==0){
                pageGroup++;

            }
            articles.get(i).setPageNum(i);
            articles.get(i).setPageGroup(pageGroup);
        }

        final int maxPageGroupNum = pageGroup;
        List<ArticleInfo> filterList = articles.stream().filter(x->x.getPageGroup() == GetpageGroup).collect(Collectors.toList());
                filterList.forEach(x->x.setMaxPageGroup(maxPageGroupNum));


        return filterList;
    }
}
