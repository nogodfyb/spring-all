package com.example.springbootconfig.controller;


import com.example.springbootconfig.config.TestConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private TestConfigBean testConfigBean;

    @GetMapping("/test")
    public String test(){
        System.out.println(testConfigBean);
        return "hello";
    }

}
