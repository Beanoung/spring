package com.beanoung.spring.test;

import com.beanoung.spring.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-xml.xml")
public class TxByXMLTest {

    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook(){
        bookController.buyBook(1,1);
    }
}
/**
 * XML声明式事务配置步骤:
 * 1.在spring的配置文件中配置事务管理器
 * 2.设置事务属性,timeout等等
 * 3.设置切入点
 * 4.需要添加依赖aspectjweaver
 */