package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.entity.Student;
import com.example.springbootmybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/test")
    public List<Student> test(){
        return studentService.test();
    }
}
