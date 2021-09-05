package com.example.springboottransaction.service.impl;


import com.example.springboottransaction.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestTransactionService {


    @Autowired
    private IUserService userService;


    public void test() {

        userService.saveParent();

        userService.saveUser();

    }


}
