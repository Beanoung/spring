package com.beanoung.spring.service.impl;

import com.beanoung.spring.dao.BookDao;
import com.beanoung.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
//@Transactional//事物管理注解,加到类上
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    // @Transactional(//事物管理注解,加到方法上
    //         readOnly = false,//只读
    //         timeout = 3,//超时,3s
    //
    //         //(不)回滚策略
    //         //rollbackFor = ArithmeticException.class,//需要设置一个Class类型的对象
    //         //rollbackForClassName ="java.lang.ArithmeticException",//需要设置一个字符串类型的全类名
    //         //声明式事务默认只针对运行时异常回滚,编译时异常不回滚,所以上面两个(回滚)一般不设置,一般设置下面两个(不回滚)
    //         noRollbackFor =ArithmeticException.class,//需要设置一个Class类型的对象     ArithmeticException算数异常
    //         noRollbackForClassName ="java.lang.ArithmeticException", //需要设置一个字符串类型的全类名
    //
    //         *
    //          * 事务隔离级别
    //          * a.读未提交:READ UNCOMMITTED      允许A事务读取B事务未提交的修改(脏读)
    //          * b.读已提交:READ COMMITTED        要求A事务读取B事务已提交的修改
    //          * c.可重复读:REPEATABLE READ       确保A事务多次从一个字段读取到相同的值(幻读)(mysql默认级别,mysql该级别解决了幻读问题)
    //          * d.串行化:SERIALIZABLE            确保A事务多次从一个表中读取到相同的行(禁止其他事务增删改,可以避免任何并发问题,但效率低)
    //
    //         isolation = Isolation.DEFAULT,
    //
    //         *
    //          * 事务的传播行为(a和d用得多)
    //          * a.必须的:REQUIRED              没有就新建，有则加入(spring默认)
    //          * b.支持:SUPPORTS                    有则加入，没有就不管了，非事务运行
    //          * c.强制的:MANDATORY                  有则加入，没有就异常
    //          * d.开启新事务:REQUIRES_NEW       不管有没有，直接创建新事务
    //          * e.不支持:NOT_SUPPORTED              不支持事务，存在就挂起
    //          * f.从不:NEVER                        不支持事务，存在就异常
    //          * g.NESTED                            存在就在嵌套的执行，没有就找是否存在外面的事务，有则加入，没有则新建
    //
    //         propagation = Propagation.REQUIRED
    // )
    public void buyBook(Integer userId, Integer bookId) {
        // try{
        //     TimeUnit.SECONDS.sleep(4);  //测试超时设置
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        //查询图书价格
        Integer price = bookDao.getPriceByBookId(bookId);
        //更新图书的库存
        bookDao.updateStock(bookId);
        //更新用户的余额
        bookDao.updateBalance(userId, price);
    }
}
