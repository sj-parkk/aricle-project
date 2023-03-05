package com.example.articletest.service;

import com.example.articletest.domain.ArticleInfo;

import com.example.articletest.domain.ArticlesPageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PageService {

    int[] pageNum = new int[2];

    public List<ArticleInfo> pagingMethod(List<ArticleInfo> articles,int GetpageGroup,int next){

        int pageGroup = 0;
        int currentGroup = 0;
        for(int i=0;i<articles.size();i++){

            if(i%5==0){
                pageGroup++;
            }
            if(i%25==0){
                currentGroup++;
            }
            if(i>25){
                articles.get(i).setPrevGroup(currentGroup-1);
            }
            articles.get(i).setPageNum(i);
            articles.get(i).setPageGroup(pageGroup);
            articles.get(i).setCurrentGroup(currentGroup);

        }

        final int maxPageGroupNum = pageGroup;
        pageNum[0] = next==1?1:((next-1)*5)+1;
        if(next==1){
            pageNum[1]=next*5;
        } else if (next>1 && next *5 <maxPageGroupNum) {
            pageNum[1]=next*5;
        } else if (next>1 && next *5 >maxPageGroupNum) {
            pageNum[1]=maxPageGroupNum;
        }
        List<ArticleInfo> filterList = articles.stream().
                filter(x->x.getPageGroup() == GetpageGroup && x.getCurrentGroup() == next).collect(Collectors.toList());
                filterList.forEach(x->{
                    x.setMaxPageGroup(maxPageGroupNum);
                    if(x.getCurrentGroup() != 1 ) x.setPrevPageExist(true);
                    if(pageNum[1] == maxPageGroupNum) x.setNextPageExist(false);
                });

        return filterList;
    }


    public int[] returnPageNum() {
        return pageNum;
    }
}
