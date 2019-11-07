package com.langg.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * StringRedisTemplate
 *
 * @author zh
 * @date 2019/11/7 11:23
 * @since 1.0.0
 */
@RestController
@RequestMapping("stringRedisTemplate")
public class StringRedisTemplateController {

    private static final String COMPANY = "company:dev";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/saveCache")
    public boolean saveOrUpdateCache(@RequestParam String key, @RequestParam String value) {
        stringRedisTemplate.opsForHash().put(COMPANY, key, value);

        return true;
    }

    @RequestMapping("/getCache")
    public String getCache(@RequestParam String key) {

        return (String) stringRedisTemplate.opsForHash().get(COMPANY, key);
    }
}
