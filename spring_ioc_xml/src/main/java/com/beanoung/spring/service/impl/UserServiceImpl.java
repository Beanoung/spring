package com.beanoung.spring.service.impl;

import com.beanoung.spring.dao.UserDao;
import com.beanoung.spring.service.UserService;

public class UserServiceImpl implements UserService {

    //同样,让IOC管理
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void savaUser() {
        userDao.saveUser();
    }
}
