package com.example.demo.controller;


import com.example.demo.exception.ApiException;
import com.example.demo.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("/test")
    public void test() {
        myService.test();
    }

    @GetMapping("/test2")
    public void test2() {
        throw new ApiException();
    }
}
