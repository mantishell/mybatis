package com.mantishell.dao;

import com.mantishell.domain.User;

import java.util.List;

public interface IUserDao {

    /**
     * 查询所有用户，同时获取到用户下所有账户的信息
     * @return
     */
    List<User> findAll();

    User findById(Integer userId);

}
