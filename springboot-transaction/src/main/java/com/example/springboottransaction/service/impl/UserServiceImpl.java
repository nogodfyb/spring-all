package com.example.springboottransaction.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboottransaction.entity.User;
import com.example.springboottransaction.mapper.UserMapper;
import com.example.springboottransaction.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author fyb
 * @since 2020-05-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public void saveParent() {

        User user = new User();
        user.setUsername("parent");
        userMapper.insert(user);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUser() {
        User user1 = new User();
        user1.setUsername("user1");
        User user2 = new User();
        user2.setUsername("user2");
        userMapper.insert(user1);
        userMapper.insert(user2);
        int i = 1 / 0;
    }


}
