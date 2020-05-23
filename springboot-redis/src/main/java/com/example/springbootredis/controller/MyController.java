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
     * 类似于HashMap
     */
    @GetMapping("/test4")
    public void test4(){
        redisTemplate.opsForHash().put("myHash1","myHashKey1","myHashValue1");
        redisTemplate.opsForHash().put("myHash1","myHashKey2","myHashValue2");
        redisTemplate.opsForHash().put("myHash1","myHashKey3","myHashValue3");
        //redisTemplate.opsForHash().putAll("myHash1",new HashMap());
    }

    /**
     * redisTemplate存储list,从左边插入，类似往数组第一个位置插入数据，其余依次往后移
     * 不过redis的list本质是一个双向链表
     */
    @GetMapping("/test5")
    public void test5(){
        for (int i = 0; i < 10; i++) {
            redisTemplate.opsForList().leftPush("myList","aaa"+i);
        }
    }

    /**
     * redisTemplate存储set
     * 类似于Java的HashSet，特点是无序，不重复
     */
    @GetMapping("/test6")
    public void test6(){
        for (int i = 0; i < 10; i++) {
            redisTemplate.opsForSet().add("mySet","aaa"+i);
        }
    }

    /**
     * redisTemplate存储sorted set
     * 特点是有序，不重复
     */
    @GetMapping("/test7")
    public void test7(){
        for (int i = 0; i < 10; i++) {
            redisTemplate.opsForZSet().add("mySortedSet","aaa"+i,i);
        }
    }
}
