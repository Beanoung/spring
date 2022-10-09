package com.beanoung.spring.test;

import com.beanoung.spring.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-annotation.xml")
public class TxByAnnotationTest {

    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook(){
        bookController.buyBook(1,1);
    }
}
/**
 * 声明式事务配置步骤:
 * 1.在spring的配置文件中配置事务管理器
 * 2.开启事务的注解驱动
 * 3.在需要被事务管理的方法或类上添加注解@Transactional,该方法或类中所有方法就会被事务管理
 */