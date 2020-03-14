package com.mantishell.test;

import com.mantishell.dao.IUserDao;
import com.mantishell.dao.impl.UserDaoImpl;
import com.mantishell.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    public static void main(String[] args) throws Exception{
        //1、读取配置
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();//创建工厂  mybatis使用了构建者模式，构建者模式：把对象的创建细节隐藏，使使用者直接调用方法即可拿到对象。
        SqlSessionFactory factory = builder.build(in);//builder就是构建者
        //3、使用工厂创建Dao对象
        IUserDao userDao = new UserDaoImpl(factory);
        //4、使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //5、释放资源
        in.close();
    }
}
