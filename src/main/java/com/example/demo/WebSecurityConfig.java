package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home", "/register", "/css/styles.css").permitAll() // Разрешить всем доступ к этим страницам
                .antMatchers("/profile").authenticated() // Требовать аутентификацию для доступа к странице профиля
                .anyRequest().authenticated() // Требовать аутентификацию для всех остальных запросов
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll() // Разрешить всем доступ к странице входа
                .and()
                .logout()
                .permitAll(); // Разрешить всем доступ к операции выхода
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/css/styles.css", "/js/**", "/img/**"); // Ignore security for static resources
    }

    @SuppressWarnings("deprecation")
    @Bean
    public PasswordEncoder noOpPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
