package com.example.articletest.config.auth;

import com.example.articletest.domain.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

//시큐리티가 /login 주소 요청이 오면 낚아채서 로그인을 진행시킨다.
//로그인 진행이 완료가 되면 시큐리티 session을 만들어준다. (Security ContextHolder)
// 오브젝트 => Authentication 타입의 객체
// Authentication 안에 User 정보가 있어야한다.
// User오브젝트타입 => UserDetails 타입 객체여아한다.
// Security Session => Authentication => UserDetails(PrincipalDetails)
public class PrinciaplDetails implements UserDetails {
    private UserInfo userInfo;

    public PrinciaplDetails(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
    //해당 User의 권한을 리턴하는 곳
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                System.out.println(userInfo.getRole());
                return userInfo.getRole();
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return userInfo.getPassword();
    }

    @Override
    public String getUsername() {
        return userInfo.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
// 1년동안 로그인 하지 않았을때 잠금하고자 하면?
    @Override
    public boolean isEnabled() {
        return true;
    }
}
