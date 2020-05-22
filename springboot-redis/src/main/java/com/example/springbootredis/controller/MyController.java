package com.example.springbootredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * stringRedisTemplate存储
     */
    @GetMapping("/test1")
    public void test1(){
        stringRedisTemplate.opsForValue().set("myKey", "hello world2");
    }

}
