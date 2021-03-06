package com.example.springboottransaction.controller;


import com.example.springboottransaction.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fyb
 * @since 2020-05-22
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/test1")
    public void test1(){
        userService.test1();
    }

    @GetMapping("/test2")
    public void test2(){
        userService.test2();
    }

    @GetMapping("/test3")
    public void test3(){
        userService.test3();
    }

    @GetMapping("/test4")
    public void test4(){
        userService.test4();
    }

    @GetMapping("/test6")
    public void test6(){
        userService.test6();
    }

}
