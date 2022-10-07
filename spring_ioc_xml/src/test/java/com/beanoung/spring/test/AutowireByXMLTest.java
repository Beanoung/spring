package com.beanoung.spring.test;

import com.beanoung.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireByXMLTest {

    @Test
    public void testAutowireByXML(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-autowire.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.savaUser();
    }
}
