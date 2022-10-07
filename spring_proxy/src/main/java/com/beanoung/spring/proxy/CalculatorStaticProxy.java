package com.beanoung.spring.proxy;

//代理类和目标类实现一样的接口
//静态代理
public class CalculatorStaticProxy implements Calculator {

    //目标对象
    private CalculatorImpl target;

    //有参构造
    public CalculatorStaticProxy(CalculatorImpl target) {
        this.target = target;
    }

    @Override
    public int add(int a, int b) {
        int result = 0;
        try {
            System.out.println("日志,方法:add,参数:" + a + "," + b);//位置1
            result = target.add(a, b);
            System.out.println("日志,方法:add,结果:" + result);//位置2
        } catch (Exception e) {
            e.printStackTrace();
            //位置3
        } finally {
            //位置4
        }
        return result;
    }

    @Override
    public int sub(int a, int b) {
        System.out.println("日志,方法:sub,参数:" + a + "," + b);
        int result = target.sub(a, b);
        System.out.println("日志,方法:sub,结果:" + result);
        return result;
    }

    @Override
    public int mul(int a, int b) {
        System.out.println("日志,方法:mul,参数:" + a + "," + b);
        int result = target.mul(a, b);
        System.out.println("日志,方法:mul,结果:" + result);
        return result;
    }

    @Override
    public int div(int a, int b) {
        System.out.println("日志,方法:div,参数:" + a + "," + b);
        int result = target.div(a, b);
        System.out.println("日志,方法:div,结果:" + result);
        return result;
    }
}
