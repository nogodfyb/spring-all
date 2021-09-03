package com.example.springboottransaction.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboottransaction.entity.User;
import com.example.springboottransaction.mapper.UserMapper;
import com.example.springboottransaction.service.IUserService;
import org.apache.ibatis.session.SqlSessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

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
    public void test() {


    }

    public void saveUser1(){
        User user = new User();
        user.setUsername("user1");
    }







}
