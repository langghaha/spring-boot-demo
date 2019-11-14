package com.langg.config;

import com.langg.interceptor.SecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 用户拦截
 *
 * @author zh
 * @date 2019/11/13 18:00
 * @since 1.0.0
 */
@Configuration
public class SessionConfig implements WebMvcConfigurer {

    @Autowired
    private SecurityInterceptor securityInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(securityInterceptor)
                //排除拦截
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/logout")

                //拦截路径
                .addPathPatterns("/**");
    }
}
