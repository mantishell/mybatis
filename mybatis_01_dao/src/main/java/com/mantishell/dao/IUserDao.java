package com.mantishell.dao;

import com.mantishell.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {

    List<User> findAll();
}
