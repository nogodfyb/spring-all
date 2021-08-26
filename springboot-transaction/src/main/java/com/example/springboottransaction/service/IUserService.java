package com.example.springboottransaction.service;

import com.example.springboottransaction.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    void test3();

    void test4();

    void test5();

    @Transactional(propagation = Propagation.REQUIRED)
    void test6();

    @Transactional(propagation = Propagation.REQUIRED)
    void test7();

    @Transactional
    void test8();
}
