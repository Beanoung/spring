package com.beanoung.spring.dao.impl;

import com.beanoung.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

//bean的类型不能是接口类型,要加到接口的实现类上
@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public void saveUser() {
        System.out.println("保存成功!");
    }
}
