package com.beanoung.spring.test;

import com.beanoung.spring.pojo.Clazz;
import com.beanoung.spring.pojo.Person;
import com.beanoung.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXMLTest {

    @Test
    public void testIOC(){

        //获取IOC
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");

        //获取bean
        //法1: bean的id
        //Student student = (Student) ioc.getBean("studentOne");
        //法2: bean的类型       注意:可能会有多个匹配,这时会抛出bean不唯一异常    或一个都没有匹配,抛出没有bean
        Student student = ioc.getBean(Student.class);   //用得多,因为一个类型的bean只需要配置一个
        //法3: 结合法1和法2,根据bean的id和类型获取
        //Student student = (Student) ioc.getBean("studentOne", "Student.class");
        System.out.println(student);

        //如果组件类(一个bean就是一个组件)实现了一个接口,可以通过接口类型获取bean(前提是bean唯一)
        Person person = ioc.getBean(Person.class);
        System.out.println(person);
        /** 结论:
         * 根据类型来获取bean时,在满足bean唯一性的前提下,
         * 其实只是看: [对象 instanceof 指定的类型]的返回结果
         * 返回true就可以认定类型匹配,就能够获取到
         * 即通过bean的类型、bean所继承的类的类型、bean实现的接口的类型,都可以获取到bean
         */
    }

    @Test
    public void testDI(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        //setter注入
        // Student studentTwo = ioc.getBean("studentTwo", Student.class);
        // System.out.println(studentTwo);
        //
        // //constructor注入
        // Student studentThree = ioc.getBean("studentThree", Student.class);
        // System.out.println(studentThree);
        //
        // //特殊赋值null
        // Student studentFour = ioc.getBean("studentFour", Student.class);
        // System.out.println(studentFour);
        //
        // //类类型的属性赋值
        Student studentFive = ioc.getBean("studentFive", Student.class);
        System.out.println(studentFive);
        //
        // //list集合的属性赋值
        // Clazz clazz = ioc.getBean(Clazz.class);
        // System.out.println(clazz);

        //p命名空间
        // Student studentSix = ioc.getBean("studentSix", Student.class);
        // System.out.println(studentSix);
    }
}
