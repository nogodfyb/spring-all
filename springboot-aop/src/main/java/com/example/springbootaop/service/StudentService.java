package com.example.springbootaop.service;

import com.example.springbootaop.mapper.StudentMapper;
import com.example.springbootaop.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public List<Student> test(){
        return studentMapper.findAll();
    }
}
