package com.example.springboottransaction.service.impl;

import com.example.springboottransaction.entity.User;
import com.example.springboottransaction.mapper.UserMapper;
import com.example.springboottransaction.service.SelfCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author fyb
 * @since 2021/9/18
 */
@Service
public class SelfCallServiceImpl implements SelfCallService {


    @Autowired
    private UserMapper userMapper;


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void test() {

        User user = new User();
        user.setUsername("user1");
        User user2 = new User();
        user2.setUsername("user2");
        userMapper.insert(user);
        userMapper.insert(user2);

        test2();

        // 异常1
        //int i = 1 / 0;
    }


    private void test2() {
        User user = new User();
        user.setUsername("user3");
        userMapper.insert(user);

        // 异常2
        int i = 1 / 0;
    }


}
