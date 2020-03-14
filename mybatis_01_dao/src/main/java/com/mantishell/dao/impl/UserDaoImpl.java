package com.mantishell.dao.impl;

import com.mantishell.dao.IUserDao;
import com.mantishell.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;
    //由于要用到SqlSessionFactory,所以需要实例化的时候，把参数传递进来
    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }
    public List<User> findAll() {
        //使用工厂创建SqlSession对象
        SqlSession session = factory.openSession();
        //使用session执行查询方法
        //statement:就是配置文件的namespace+id
        List<User> users = session.selectList("com.mantishell.dao.IUserDao.findAll");
        session.close();
        return users;
    }
}
