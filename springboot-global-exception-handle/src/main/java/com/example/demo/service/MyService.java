package com.example.demo.service;

import com.example.demo.exception.ApiException;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    public void test(){
        ApiException apiException = new ApiException();
        throw apiException;
    }
}
