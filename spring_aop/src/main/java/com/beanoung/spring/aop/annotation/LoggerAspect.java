package com.beanoung.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.security.cert.CertPathBuilderResult;
import java.util.Arrays;

//日志切面
@Component
@Aspect     //将当前组件标识为切面
public class LoggerAspect {

    //切入点表达式重用
    @Pointcut("execution(* com.beanoung.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut() {
    }

    //前置通知
    //@Before("execution(public int com.beanoung.spring.aop.annotation.CalculatorImpl.add(int,int))")//value = 切入点表达式
    //@Before("execution(* com.beanoung.spring.aop.annotation.*.*(..))")//更常用的方式(不写..就是无参)
    @Before("pointCut()")//切入点表达式重用
    public void beforeAdviceMethod(JoinPoint joinPoint) {
        //获取连接点所对应的方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应的方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect->前置通知,方法:" + signature.getName() + ",参数:" + Arrays.toString(args));
    }

    //后置通知      在目标对象方法的finally中执行
    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect->后置通知,方法:" + signature.getName() + ",执行完毕");
    }

    //返回通知      在目标对象方法返回值之后执行      returning设置接收返回结果的参数名
    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturnAdviceMethod(JoinPoint joinPoint, Object result) {
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect->返回通知,方法:" + signature.getName() + ",结果:" + result);
    }

    //异常通知      在目标对象的catch中执行           throwing设置接收异常信息的参数名
    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Exception e) {
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect->异常通知,方法:" + signature.getName() + ",异常:" + e);
    }

    //环绕通知      目标对象方法不执行,在这里执行
    @Around("pointCut()")           //特殊的参数ProceedingJoinPoint
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            System.out.println("---前置通知---");
            //表示目标对象方法的执行
            result = joinPoint.proceed();
            System.out.println("---返回通知---");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("---异常通知---");
        } finally {
            System.out.println("---后置通知---");
        }
        return result;
    }
}
