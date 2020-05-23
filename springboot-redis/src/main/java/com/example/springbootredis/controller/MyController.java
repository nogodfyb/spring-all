package com.example.springbootredis.controller;

import com.example.springbootredis.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * stringRedisTemplate 存储string
     */
    @GetMapping("/test1")
    public void test1(){
        stringRedisTemplate.opsForValue().set("myKey", "hello world2");
    }

    /**
     * redisTemplate存储对象 本质上是序列化成Json格式的的字符串存储到redis当中
     */
    @GetMapping("/test2")
    public void test2(){
        Person person = new Person();
        person.setName("fyb");
        person.setAge(18);
        person.setGender("male");
        redisTemplate.opsForValue().set("userInfo",person);
    }

    /**
     * redisTemplate取出对象 本质上是将redis中Json字符串反序列化成对象
     */
    @GetMapping("/test3")
    public void test3(){
        Object userInfo = redisTemplate.opsForValue().get("userInfo");
        System.out.println((Person)userInfo);
    }

    /**
     * redisTemplate存储Hash
     */
    @GetMapping("/test4")
    public void test4(){
        redisTemplate.opsForHash().put("myHash","myHashKey","myHashValue");
    }

}
