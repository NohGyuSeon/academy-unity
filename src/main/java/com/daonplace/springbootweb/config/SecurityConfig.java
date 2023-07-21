package com.daonplace.springbootweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
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
            .antMatchers("/", "/user/**", "/admin/**").authenticated() // 인증이 필요한 페이지
            .antMatchers("/user/**").hasRole("USER") // 사용자 권한 설정
            .antMatchers("/admin/**").hasRole("ADMIN") // 관리자 권한 설정
            .anyRequest().permitAll() // 그 외의 요청은 허가함
            .and()
            .formLogin() // 로그인 폼 활성화
            .loginPage("/auth/signin") // 로그인 페이지 설정 [GET]
            .loginProcessingUrl("/auth/signin") // 로그인 처리 URL [POST]
            .defaultSuccessUrl("/")
            .usernameParameter("email");

//            .antMatchers("/auth/**", "/css/**", "/images/**", "/js/**")
//            .permitAll() // 로그인 관련 요청은 모두 허용
//            .anyRequest().authenticated() // 그 외의 요청은 인증이 필요함
//            .and()
//            .formLogin() // 폼 로그인 활성화
//            .loginPage("/auth/signin") // 로그인 페이지 설정
//            .loginProcessingUrl("/auth/signin") // 로그인 처리 URL
//            .defaultSuccessUrl("/") // 로그인 성공 시 이동할 페이지
//            .usernameParameter("email") // name 파라미터는 email 로 설정
//            .permitAll()


//            .and()
//            .sessionManagement() // 세션 관리 설정 추가
//            .sessionCreationPolicy(SessionCreationPolicy.ALWAYS) // 항상 세션 생성
//            .sessionFixation().migrateSession() // 세션 고정 보호 활성화
//            .maximumSessions(1) // 동시 로그인 세션 수
//            .maxSessionsPreventsLogin(false) // 추가 로그인 허용 여부
//            .and()
//            .and()
//            .logout() // 로그아웃 설정 추가
//            .logoutUrl("/auth/signout") // 로그아웃 URL
//            .logoutSuccessUrl("/auth/signin?logout") // 로그아웃 성공 시 이동할 URL
//            .invalidateHttpSession(true) // 세션 무효화
//            .deleteCookies("JSESSIONID"); // 세션 쿠키 삭제
    }

}
