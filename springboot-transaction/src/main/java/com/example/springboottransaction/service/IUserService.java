package com.example.springboottransaction.service;

import com.example.springboottransaction.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fyb
 * @since 2020-05-22
 */
public interface IUserService extends IService<User> {

    void test1();

    void test2();
}
