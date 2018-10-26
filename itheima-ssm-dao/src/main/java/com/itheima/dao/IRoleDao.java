package com.itheima.dao;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {

    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class,
                    many = @Many(select = "com.itheima.dao.IPermissionsDao.findByIdPermission")
            )
    })
    public List <Role> findRoleByUserIdOne(String userId) throws Exception;


    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    public List <Role> findRoleByUserId(String userId) throws Exception;

    //    查询所有角色
    @Select("select * from role")
    List <Role> findAllRole() throws Exception;

    //    新建一个角色信息
    @Insert("insert into role (roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void saveRole(Role role) throws Exception;

    //    根据roleId查询role
    @Select("select * from role where id=#{roleId}")
    Role findById(String roleId) throws Exception;

    //    查询出可以添加的权限
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List <Permission> findOtherPermissions(String roleId) throws Exception;

    //    给角色添加权限信息
    @Insert("insert into role_permission (roleId,permissionId) values (#{id},#{permissionId})")
    void addPermissionToRole(@Param("id") String id, @Param("permissionId") String permissionId);
}
