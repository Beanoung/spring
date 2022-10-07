package com.beanoung.spring.test;

import com.beanoung.spring.aop.annotation.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPByAnnotationTest {

    @Test
    public void testAOPByAnnotation(){
        //获取ioc容器
        ApplicationContext ioc=new ClassPathXmlApplicationContext("aop-annotation.xml");
        //获取代理对象的bean(通过所实现的接口)(没有CalculatorImpl的bean)
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.div(4,2);
    }
}
