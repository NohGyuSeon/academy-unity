package com.daonplace.springbootweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity // 해당 파일로 시큐리티를 활성화 시키는 어노테이션
@Configuration // IoC 컨테이너로 넣어주는 어노테이션
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() // CSRF 토큰 검사를 비활성화
            .authorizeRequests() // 인가 설정
            .antMatchers("/", "/user/**", "/admin/**").authenticated() // 해당 경로는 인증이 필요함
            .anyRequest().permitAll() // 그 외의 요청은 허용
            .and()
            .formLogin() // 폼 로그인 활성화
            .loginPage("/auth/signin") // 로그인 페이지 설정
            .loginProcessingUrl("/auth/signin") // 로그인 처리 URL
            .defaultSuccessUrl("/") // 로그인 성공 시 이동할 페이지
            .usernameParameter("email");
    }

}
