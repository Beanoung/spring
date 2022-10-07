package com.beanoung.spring.controller;

import com.beanoung.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    //使用注解自动装配  @Autowired
    //1.成员变量上,此时不需要为当前成员变量设置set方法(推荐)
    @Autowired(required = false)
    //@Qualifier("userServiceImpl")
    private UserService userService;

    //2.在set方法上
    //@Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //3.有参构造上
    //@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void saveUser(){
        userService.saveUser();
    }
}
