package com.beanoung.spring.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//生命周期中两个额外的操作
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    //此方法在bean的生命周期初始化之前执行
    //bean: 当前bean  beanName: bean的id
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("生命周期3:MyBeanPostProcessor->后置处理器postProcessBeforeInitialization方法");
        return bean;
    }

    @Override
    //此方法在bean的生命周期初始化之后执行
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("生命周期5:MyBeanPostProcessor->后置处理器postProcessAfterInitialization方法");
        return bean;
    }
}
