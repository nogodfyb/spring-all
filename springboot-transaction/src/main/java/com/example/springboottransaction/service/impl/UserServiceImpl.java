package com.example.springboottransaction.service.impl;

import com.example.springboottransaction.entity.User;
import com.example.springboottransaction.mapper.UserMapper;
import com.example.springboottransaction.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fyb
 * @since 2020-05-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    /**
     * 出现运行时异常不捕获处理的话，前面的插入操作，成功了，后面的插入失败。
     * 当对异常做了捕获处理,前后插入都能成功，但是出现异常说明本次批量操作不合法，应该一致成功或一致失败
     */
    public void test1(){
        User user = new User();
        user.setUsername("fyb1");
        save(user);
        user.setUsername("fyb2");
        //故意设置异常
        try {
            int i=1/0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        save(user);
    }

    @Override
    @Transactional
    public void test2(){
        User user = new User();
        user.setUsername("fyb1");
        save(user);
        user.setUsername("fyb2");
        // 异常如果被捕获了，事务式不起作用的，换句话说既然你已经处理了异常，这个异常即使发生了，也不会回滚
        int i=1/0;
        save(user);
    }
}
