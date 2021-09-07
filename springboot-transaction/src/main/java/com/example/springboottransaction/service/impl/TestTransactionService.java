package com.example.springboottransaction.service.impl;


import com.example.springboottransaction.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestTransactionService {


    @Autowired
    private IUserService userService;


    @Transactional(propagation = Propagation.REQUIRED)
    public void test() {

        userService.saveParent();

        userService.saveUser();

        //异常1
        //int i = 1 / 0;

    }


}
