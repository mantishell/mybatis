package com.mantishell.dao;

import com.mantishell.domain.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IRoleDao {
    @Select("select * from role")
    @Results(id = "roleMap",value={//这里的id是标识符，唯一标志
            @Result(id=true,property = "roleId",column = "id"),//id=true表示这个是主键，property代表实体名，column代表数据库字段名
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "roleDesc", column = "role_desc"),
            @Result(property = "users", column = "id",many = @Many(
                    select = "com.mantishell.dao.IUserDao.findUsersById",fetchType = FetchType.LAZY //使用延迟加载
            ))
    })
    List<Role> findAll();

    /*角色表和中间表联合后检索*/
    @Select("select * from role r inner join user_role ur on ur.rid=r.id where ur.uid=#{id}")
    @ResultMap("roleMap")//取上面填写的标识符，省去重复编写映射信息
    List<Role> findRolesById(int id);
}
