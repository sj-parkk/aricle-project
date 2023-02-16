package com.example.articletest.config.auth;

import com.example.articletest.domain.UserInfo;
import com.example.articletest.mapper.ArticleMapper;
import com.example.articletest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
//시큐리티 설정에서 loginProceesingUrl("/login");
// /login 설청이 오면 자동으로 UserDetailsService 타입으로 IoC되어 있는 loadUserByUsername 함수 실행
@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    // 시큐리티 session(Authentication(UserDetails))
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userMapper.getUserById(username);
        if(userInfo!=null){
            return new PrinciaplDetails(userInfo);
        }
        return null;
    }
}
