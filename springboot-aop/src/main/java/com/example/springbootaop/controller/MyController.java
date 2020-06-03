package com.example.springbootaop.controller;

import com.example.springbootaop.aop.Log;
import com.example.springbootaop.entity.Student;
import com.example.springbootaop.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/test")
    @Log("方法test")
    public List<Student> test(){
        return studentService.test();
    }
}
