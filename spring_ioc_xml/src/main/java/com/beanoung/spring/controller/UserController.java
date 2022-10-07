package com.beanoung.spring.controller;

import com.beanoung.spring.dao.UserDao;
import com.beanoung.spring.service.UserService;

public class UserController {

    //硬编码,写死了
    // private UserService userService=new UserServiceImpl();

    //可以让IOC来管理
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void savaUser(){
        userService.savaUser();
    }
}
