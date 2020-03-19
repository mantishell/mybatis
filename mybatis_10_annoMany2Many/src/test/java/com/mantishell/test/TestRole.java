package com.mantishell.test;

import com.mantishell.dao.IRoleDao;
import com.mantishell.domain.Role;
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

public class TestRole {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IRoleDao roleDao;

    @Before
    public  void init()throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        roleDao = session.getMapper(IRoleDao.class);
    }

    @After
    public  void destroy()throws  Exception{
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        List<Role> roles = roleDao.findAll();
        List<User> users = null;
        for (Role role : roles) {
            users = role.getUsers();
            if(users.size()> 0){
                System.out.println(role);
                System.out.println(users);
            }
        }
    }
}
