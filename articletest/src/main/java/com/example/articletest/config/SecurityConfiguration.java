package com.example.articletest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록
@EnableMethodSecurity
public class SecurityConfiguration {
//"hasRole('ROLE_ADMIN') hasRole('ROLE_MANAGER')"
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        http.csrf().disable();
        http.authorizeHttpRequests()
                .requestMatchers("/user/**").authenticated()
                .requestMatchers("/Admin/**").hasRole("ADMIN")
                .requestMatchers("/Article/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/LoginForm") // authenticated() 이외의 페이지는 login 페이지로 이동
                .loginProcessingUrl("/login")// login 주소가 호출되면 시큐리티가 낚아채서 대신 로그인 진행
                .defaultSuccessUrl("/")
        ;





        return http.build();
    }
    // 해당 메서드의 리턴되는 오브젝트를 IoC로 등록해준다.
    @Bean
    public BCryptPasswordEncoder encoderPwd(){
        return new BCryptPasswordEncoder();
    }
}
