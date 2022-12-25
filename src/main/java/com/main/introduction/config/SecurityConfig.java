package com.main.introduction.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*
            CSRF(Cross site Request forgery)
              - 정상적인 사용자가 의도치 않은 위조요청을 보내는 행위

            * Rest API에서 CSRF를 Disable 하는 이유
              - Spring security Document quotation
                non-browser client 서비스면 CSRF Disable 허용
                rest api 서버라면 session 기반과 다르게 Stateless하기 때문에 서버에 인증 정보를 보관하지 않음.
                rest api에서 client는 권한이 필요한 요청을 하기 위해서는 요청에 필요한 정보를(Oauth2, jwt토큰 등)을 포함시켜야한다.
         */

        // 인가 정책 설정
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/**")
                .authenticated();
    }

    public void configureGlobal(AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password(passwordEncoder.encode("password")).roles("USER");
    }
}
