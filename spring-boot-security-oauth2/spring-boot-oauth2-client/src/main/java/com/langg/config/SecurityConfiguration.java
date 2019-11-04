package com.langg.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * security配置
 * This class defines the Spring Security configuration for your application: allowing all requests on the home path and requiring authentication for all other routes. it also sets up the Spring Boot OAuth login flow
 *
 * @author zh
 * @date 2019/11/4 14:53
 * @since 1.0.0
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**").authorizeRequests()
                .antMatchers("/", "/login**").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();
    }
}
