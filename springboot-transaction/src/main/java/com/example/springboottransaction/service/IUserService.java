package com.example.springboottransaction.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboottransaction.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fyb
 * @since 2020-05-22
 */
public interface IUserService extends IService<User> {


    void saveParent();

    void saveUser();
}
