package com.example.springbootaop.service.impl;

import com.example.springbootaop.entity.User;
import com.example.springbootaop.mapper.UserMapper;
import com.example.springbootaop.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fyb
 * @since 2020-06-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
