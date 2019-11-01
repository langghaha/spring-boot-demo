package com.langg;

import com.langg.config.AcmeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * springboot配置
 *
 * @author zhuhao
 * @date 2019/11/1 22:20
 * @since 1.0.0
 **/
@SpringBootApplication
@RestController
public class ConfigurationApplication {

    private final AcmeProperties acmeProperties;

    @Autowired
    public ConfigurationApplication(AcmeProperties properties) {
        this.acmeProperties = properties;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationApplication.class, args);
    }

    @RequestMapping("getAcmeProperties")
    public String getAcmeProperties() {
        return this.acmeProperties.toString();
    }
}
