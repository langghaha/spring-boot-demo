package com.langg.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * RedisTemplate
 *
 * @author zh
 * @date 2019/11/7 10:26
 * @since 1.0.0
 */
@RestController
@RequestMapping("redisTemplate")
public class RedisTemplateController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/saveOrUpdateCache")
    public boolean saveOrUpdateCache(@RequestParam String key, @RequestParam String value) {
        redisTemplate.opsForValue().set(key, value);

        return true;
    }

    @RequestMapping("/getCache")
    public String saveCache(@RequestParam String key) {
        String value = (String) redisTemplate.opsForValue().get(key);

        return value;
    }

    @RequestMapping("/deleteCache")
    public boolean deleteCache(@RequestParam String key) {

        return redisTemplate.delete(key);
    }
}
