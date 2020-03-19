package com.mantishell.dao;

import com.mantishell.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@CacheNamespace(blocking=true)//mybatis 基于注解方式实现配置二级缓存
public interface IUserDao {

    @Select("select * from user")
    @Results(id="userMap",value={//这里的id是标识符，唯一标志
            @Result(id=true,property = "id",column = "id"),//id=true表示这个是主键，property代表实体名，column代表数据库字段名
            @Result(property = "username",column = "username"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "roles", column = "id",many = @Many(
                    select = "com.mantishell.dao.IRoleDao.findRolesById",fetchType = FetchType.LAZY
            ))
    })
    List<User> findAll();

    /*用户表和中间表联合后检索*/
    @Select("select * from user u inner join user_role ur on u.id=ur.uid where ur.rid=#{id}")
    @ResultMap("userMap")//取上面填写的标识符，省去重复编写映射信息
    List<User> findUsersById(int id);
}
