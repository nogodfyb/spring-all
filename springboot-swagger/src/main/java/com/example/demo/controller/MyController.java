package com.example.demo.controller;


import com.example.demo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "我的API",tags = {"用于XXX的相关接口"})
@RestController
public class MyController {


    @GetMapping("getUser")
    @ApiOperation(value = "接口一",notes = "接口一notes",httpMethod = "GET")
    public User getUser() {

        User user = new User();
        user.setName("fyb");
        user.setAge(18);

        return user;
    }

    @PostMapping("testPost")
    @ApiOperation(value = "接口二",notes = "接口二notes",httpMethod = "POST")
    public User postTest(@RequestBody User param) {

        User user = new User();
        user.setName("fyb");
        user.setAge(18);

        return user;
    }

}
