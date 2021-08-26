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
    /**
     * 出现运行时异常不捕获处理的话，前面的插入操作，成功了，后面的插入失败。
     * 当对异常做了捕获处理,前后插入都能成功，但是出现异常说明本次批量操作不合法，应该一致成功或一致失败
     */
    public void test1() {
        User user = new User();
        user.setUsername("fyb1");
        save(user);
        user.setUsername("fyb2");
        //故意设置异常
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        save(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void test2() {
        User user = new User();
        user.setUsername("fyb1");
        save(user);
        user.setUsername("fyb2");
        // 异常如果被捕获了，事务式不起作用的，换句话说既然你已经处理了异常，这个异常即使发生了，也不会回滚
        int i = 1 / 0;
        save(user);
    }

    /**
     * 外部方法没有开启事务
     * 内部方法开启了事务
     * 外部方法和内部方法都没有回滚，是否是因为没有直接操作dao层的mapper的缘故呢，不是
     * 之所以内部方法也没有回滚，是因为同类调用，动态代理失效
     */
    @Override
    public void test3() {
        User user = new User();
        user.setUsername("fyb3");
        save(user);
        test2();
    }

    @Override
    public void test4() {
        User user = new User();
        user.setUsername("fyb1");
        userMapper.insert(user);
        test5();
    }

    /**
     * 结论是无论是操作mapper还是操作继承于接口的默认方法
     * 外部方法没有开启事务，内部方法开启了事务，两者都无法回滚
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void test5() {
        User user = new User();
        user.setUsername("fyb2");
        userMapper.insert(user);
        //设置异常
        int i = 1 / 0;
        user.setUsername("fyb3");
        userMapper.insert(user);
    }

    /**
     * 外部方法开启了事务，内部方法没有开启事务，当内部方法出现异常，两者都会回滚;
     * 另外在这种情况下，当内部方法没有出现异常，外部方法出现异常，两者也会回滚
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void test6() {
        User user = new User();
        user.setUsername("fyb1");
        save(user);
        test7();
        user.setUsername("fyb2");
        save(user);
    }

    @Override
    public void test7() {
        User user = new User();
        user.setUsername("fyb3");
        save(user);
        //设置异常
        int i = 1 / 0;
        user.setUsername("fyb4");
        save(user);
    }

    /**
     * catch中的异常不是实际抛出的异常的父类型或者对应的异常,捕获并不会成功,所以并不会影响回滚
     */
    @Transactional
    @Override
    public void test8() {

        User user = new User();
        user.setUsername("fyb8");
        save(user);

        try {
            int i = 1 / 0;
        } catch (SqlSessionException exception) {
            System.out.println(exception.toString());
        }

    }


}
