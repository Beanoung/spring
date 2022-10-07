package com.beanoung.spring.test;

import com.beanoung.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {

    /**
     *生命周期:1.实例化
     * 2.依赖注入
     * 3.后置处理器postProcessBeforeInitialization方法
     * 4.初始化,通过bean的属性init-method指定初始化方法
     * 5.后置处理器postProcessAfterInitialization方法
     * 6.销毁,通过bean的属性destroy-method指定销毁方法,IOC容器关闭时销毁
     */
    @Test
    public void testLifeCycle(){
        //ConfigurableApplicationContext是ApplicationContext的子接口,提供刷新和关闭ioc的功能
        ConfigurableApplicationContext ioc=new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        //单例的时候,在获取ioc时就会完成前五个生命周期,因为单例以后用的都是同一个,可以提前创建\
        //多例是在获取bean时完成前五个生命周期
        User user = ioc.getBean(User.class);
        System.out.println(user);
        ioc.close();
        //多例的时候,销毁就不由ioc管理
    }
}
