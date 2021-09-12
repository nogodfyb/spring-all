package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户对象", description = "用于对象的说明,客户端由用户传入的数据封装在次entity中")
public class User {


    @ApiModelProperty(value = "用户名",name ="name",example = "fyb",required = true)
    private String name;

    @ApiModelProperty(value = "年龄",name ="age",example = "12",required = true)
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
