package com.beanoung.spring.test;

import com.beanoung.spring.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//设置运行环境,Spring的环境,就可以直接通过注入的方式获取ioc容器的bean
@ContextConfiguration("classpath:spring-jdbc.xml")//设置spring测试环境的配置文件
public class JdbcTemplateTest {

    @Autowired//自动装配
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert() {
        String sql = "insert into t_user values(null,?,?,?,?,?)";
        jdbcTemplate.update(sql, "root", "123", 18, "女", "root@qq.com");
    }

    @Test
    public void testSelect(){
        String sql="select * from t_user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 1);
        System.out.println(user);
    }

    @Test
    public void testSelectAll(){
        String sql="select * from t_user";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        list.forEach(System.out::println);
    }

    @Test
    public void testSelectCount(){
        String sql="select count(*) from t_user";
        Integer c = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(c);
    }
}
