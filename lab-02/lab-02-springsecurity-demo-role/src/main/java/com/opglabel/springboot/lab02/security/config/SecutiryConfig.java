package com.opglabel.springboot.lab02.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecutiryConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/test/demo").permitAll() // 所有用户可以访问
                .antMatchers("/test/admin").hasRole("ADMIN") // admin 用户可以访问
                .antMatchers("/test/normal").access("hasRole('ROLE_NORMAL')") // 需要normal角色可以访问
                .anyRequest().authenticated() // 任何请求访问 的用户都需要认证
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .permitAll();


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用内存中的 InMemoryUserDetailsManager
        auth.inMemoryAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance())  // 不使用 PasswordEncoder 编码器
                //配置admin用户
                .withUser("admin").password("admin").roles("ADMIN")
                .and()
                // 配置normal 用户
                .withUser("normal").password("normal").roles("NORMAL");

    }
}
