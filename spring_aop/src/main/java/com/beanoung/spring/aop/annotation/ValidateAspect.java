package com.beanoung.spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//验证切面
@Component
@Aspect
@Order(1)//优先级设置,值越小优先级越高
public class ValidateAspect {

    //@Before("execution(* com.beanoung.spring.aop.annotation.CalculatorImpl.*(..))")
    @Before("com.beanoung.spring.aop.annotation.LoggerAspect.pointCut()")
    public void beforeMethod(){
        System.out.println("ValidateAspect->前置通知");
    }
}
