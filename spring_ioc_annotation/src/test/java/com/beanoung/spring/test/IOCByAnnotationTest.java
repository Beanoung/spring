package com.beanoung.spring.test;

import com.beanoung.spring.controller.UserController;
import com.beanoung.spring.dao.UserDao;
import com.beanoung.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 通过注解管理bean
 * 常用注解:
 * @Component 将类标识为普通组件(不是下面三种的时候用这个)
 * @Controller 将类标识为控制层组件
 * @Service 将类标识为业务层组件
 * @Repository 将类标识为持久层组件
 * 他们功能是一样的,区别是给开发人员用于分辨组件的作用(可读性)
 *
 * 通过注解+扫描所配置的bean的id:  默认为类小驼峰,即类名首字母小写    可以在注解后面("")设置id     比如@Controller("controller")
 * 一般不需要配置id,一般使用类来获取bean,但文件解析器就需要id来配置...
 *
 * @Autowired:实现自动装配功能的注解
 * 能够标识的位置:
 * 1.成员变量上,此时不需要设置set方法
 * 2.set方法上
 * 3.为当前成员变量赋值的有参构造上    
 * 原理:
 * 1.默认通过byType的方式,在IOC容器中通过类型匹配某个bean来为属性赋值
 * 2.若有多个类型匹配的bean,此时会自动转换为byName的方式进行自动装配,即将要赋值的属性的属性名作为bean的id来匹配bean
 * 3.如果有多个类型匹配的bean,且bean的id都不与属性名不同,此时抛异常(没有唯一bean),这时使用注解@Qualifier("id"),指定bean的id
 *
 * 如果没有任何一个bean匹配,此时抛异常(NoSuchBean...)
 * 注解@Autowired可以配置一个required属性,默认值为true,要求必须完成装配,设置为false则尽量装配,无法装配时使用属性的默认值
 */

public class IOCByAnnotationTest {

    @Test
    public void testIOCByAnnotation(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        //controller层
        UserController userController = ioc.getBean(UserController.class);
        // System.out.println(userController);
        // //service层
        // UserService userService = ioc.getBean(UserService.class);
        // System.out.println(userService);
        // //dao层
        // UserDao userDao = ioc.getBean(UserDao.class);
        // System.out.println(userDao);
        userController.saveUser();
    }
}
