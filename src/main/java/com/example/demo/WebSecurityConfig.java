package com.example.demo;
// ожидает базу данных
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
                .antMatchers("/css/**", "/js/**", "/img/**").permitAll()
                .antMatchers("/", "/home", "/register", "/css/styles.css").permitAll() // Разрешить всем доступ к этим страницам
                .antMatchers("/login").permitAll() // Permit all for login page
                .antMatchers("/profile").permitAll() // Permit all for login page
                //.antMatchers("/profile").authenticated() // Требовать аутентификацию для доступа к странице профиля
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

// НЕ ТРОГАЙТЕ закомментированные коды
   // @Bean
    //public PasswordEncoder passwordEncoder() {
      //  return new BCryptPasswordEncoder();
    // }
  //  @Autowired
    // private UserDetailsService userDetailsService;

    //@Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //  auth.userDetailsService(userDetailsService)
    //        .passwordEncoder(passwordEncoder());
    //}

}
