package com.example.springboottransaction.controller;


import com.example.springboottransaction.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author fyb
 * @since 2020-05-22
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/test")
    public void test1() {
        userService.test();
    }


}
