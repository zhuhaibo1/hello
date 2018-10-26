package com.itheima.dao;

import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id" ,
                    javaType = java.util.List.class,
                    many =@Many(select = "com.itheima.dao.IRoleDao.findRoleByUserId")
            )
    })
    UserInfo findByUsername(String username) throws Exception;


    @Select("select * from users")
    List<UserInfo> findAllUser() throws Exception;


    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void saveUser(UserInfo userInfo);


    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id" ,
                    javaType = java.util.List.class,
                    many =@Many(select = "com.itheima.dao.IRoleDao.findRoleByUserIdOne")
            )
    })
    UserInfo findByIdUser(String id);

//    查询用户可以添加的角色
    @Select("select * from role where id not in (select roleId from users_role where userId=#{id})")
    List<Role> findOtherRoles(String id);

//    给用户添加角色
    @Insert("insert into users_role (userId,roleId) values (#{id},#{roleId})")
    void addRoleToUser(@Param("id") String id,@Param("roleId") String roleId);
}
