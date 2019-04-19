package com.spring.boot.step.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author dongzonglei
 * @description
 * @date 2019-04-19 12:13
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin().failureUrl("/login?error").defaultSuccessUrl("/ayUser/test")
                .permitAll();
        super.configure(http);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("阿毅").password("123456").roles("ADMIN")
//                .and()
//                .withUser("阿兰").password("123456").roles("USER");
        auth.userDetailsService(customUserService());
    }

    public CustomUserService customUserService() {
        return new CustomUserService();
    }
}
