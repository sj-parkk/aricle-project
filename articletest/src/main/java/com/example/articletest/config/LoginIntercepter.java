package com.example.articletest.config;

import com.example.articletest.domain.UserInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import java.util.Arrays;
import java.util.List;

public class LoginIntercepter implements HandlerInterceptor {
    public List loginEssential
            = Arrays.asList("/Admin/**","/ArticleWrite","/Article/**");
    public List loginNonEssential
            = Arrays.asList("/LoginForm","/SignUp","/alert","");
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserInfo session = (UserInfo) request.getSession().getAttribute("loginMember");
        if(session == null){
            System.out.println(request.getRequestURI().toString());
            String destUri = request.getRequestURI();
            String destQuery = request.getQueryString();
            String dest = (destQuery==null)?destUri:destUri+"?"+destQuery;
            request.getSession().setAttribute("dest",dest);
            response.sendRedirect("/LoginForm");
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
