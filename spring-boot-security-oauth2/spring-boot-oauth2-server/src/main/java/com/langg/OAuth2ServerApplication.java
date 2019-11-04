package com.langg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * oauth2 server启动类
 *
 * @author zh
 * @date 2019/11/4 14:18
 * @since 1.0.0
 */
@SpringBootApplication
@EnableResourceServer
public class OAuth2ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2ServerApplication.class, args);
    }
}
