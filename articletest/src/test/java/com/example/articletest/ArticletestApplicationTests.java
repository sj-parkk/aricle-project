package com.example.articletest;

import com.example.articletest.domain.ArticleInfo;
import com.example.articletest.mapper.ArticleMapper;
import com.example.articletest.service.PageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class ArticletestApplicationTests {


	@Autowired
	PageService pageService;
	@Autowired
	ArticleMapper articleMapper;


	@Test
	void contextLoads() {
		List<ArticleInfo> articleInfoList = articleMapper.getArticles();
//		pageService.pagingMethod(articleInfoList,5,1)
//				.forEach(x-> System.out.println(x.getContent()));
		int pageGroup = 0;
		int nextPage = 0;

		pageService.pagingMethod(articleInfoList, 6, 2);
		int[] x = pageService.returnPageNum();
		System.out.println(x[0] + " " + x[1]);
	}


}
