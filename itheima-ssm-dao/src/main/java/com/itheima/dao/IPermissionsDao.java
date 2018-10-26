package com.itheima.dao;

import com.itheima.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IPermissionsDao {
//    findRoleByUserIdOne
    @Select("select * from permission where id in(select permissionId from role_permission where roleId=#{id})")
    List<Permission> findByIdPermission(String id) throws  Exception;

//    查询所有资源权限
    @Select("select * from permission")
    List<Permission> findAllPermission() throws Exception;

//    添加资源权限
    @Insert("insert into permission (permissionName,url) values(#{permissionName},#{url})")
    void savePermission(Permission permission) throws Exception;
}
