package com.beanoung.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

//动态代理
public class ProxyFactory {

    private Object target;

    //有参构造
    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy(){
        /**
         * ClassLoader loader:指定加载动态生成的代理类的类加载器
         * Class<?>[] interfaces:获取目标对象实现的所有的接口的class对象的数组
         * InvocationHandler h:设置代理类中的抽象方法如何重写
         */
        //ClassLoader classLoader = ProxyFactory.class.getClassLoader();
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        //匿名内部类
        InvocationHandler h=new InvocationHandler() {
            @Override
            //proxy:代理对象    method:要执行的方法   args:要执行的方法的参数列表
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //args是Object类型,想看到需要转换成toString
                Object result = null;
                try {
                    System.out.println("日志,方法:"+method.getName()+",参数:"+ Arrays.toString(args));//位置1
                    result = method.invoke(target, args);
                    System.out.println("日志,方法:"+method.getName()+",结果:"+ result);//位置2
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("日志,方法:"+method.getName()+",异常:"+ e);//位置3
                } finally {
                    System.out.println("日志,方法:"+method.getName()+",执行完毕!");//位置4
                }
                return result;
            }
        };
        //代理实例
        return Proxy.newProxyInstance(classLoader,interfaces,h);
    }
}
