package com.mantishell.dao;

import com.mantishell.domain.QueryVo;
import com.mantishell.domain.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();

    User findById(Integer userId);

    List<User> findByName(String name);

    List<User> findUserByVo(QueryVo vo);

    List<User> findUserByCondition(User user);

    List<User> findUserInIds(QueryVo vo);
}
