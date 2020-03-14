package com.mantishell.dao;

import com.mantishell.domain.QueryVo;
import com.mantishell.domain.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);

    User findById(Integer userId);

    List<User> findByName(String name);

    //查询总记录数
    int findTotal();

    List<User> findUserByVo(QueryVo vo);
}
