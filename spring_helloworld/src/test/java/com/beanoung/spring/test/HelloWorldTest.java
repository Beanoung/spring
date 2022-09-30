package com.beanoung.spring.test;

import com.beanoung.spring.pojo.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {
    @Test
    public void testHelloWorld(){

        //获取IOC容器,  configLocation:xml文件路径
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean对象,通过bean的id
        HelloWorld helloworld = (HelloWorld) ioc.getBean("helloworld");
        helloworld.sayHell();
    }
}
