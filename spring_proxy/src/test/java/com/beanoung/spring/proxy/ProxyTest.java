package com.beanoung.spring.proxy;

import org.junit.Test;

public class ProxyTest {

    @Test
    public void testProxy(){
        //静态代理
        // CalculatorStaticProxy calculatorStaticProxy=new CalculatorStaticProxy(new CalculatorImpl());
        // calculatorStaticProxy.add(1,2);

        //动态代理
        ProxyFactory proxyFactory=new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(2,3);
        proxy.div(2,0);//异常
    }
}

/**
 * 两种动态代理:(这里用的jdk动态代理,AOP封装了动态代理)
 * 1. jdk动态代理,要求必须有接口,最终生成的代理类和目标类实现相同的接口,在com.sun.proxy包下,类名为$proxy加个数字
 * 2. cglib动态代理,最终生成的代理类会继承目标类,并且和目标类在相同的包下
 */