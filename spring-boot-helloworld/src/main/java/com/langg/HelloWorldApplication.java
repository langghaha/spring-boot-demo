package com.langg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * helloworld启动类
 *
 * @author zhuhao
 * @date 2019/10/31 21:28
 * @since 1.0.0
 **/
@SpringBootApplication
@RestController
public class HelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }

    /**
     * 浏览器输入 ip:8001/hello
     * 界面显示Hello World
     *
     * @return
     */
    @RequestMapping("hello")
    public String sayHelloWorld() {
        return "Hello World";
    }
}
