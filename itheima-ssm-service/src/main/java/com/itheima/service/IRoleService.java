package com.itheima.service;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;

import java.util.List;

public interface IRoleService {
//    查询所有用户信息
    List<Role> findAllRole(int page,int size) throws Exception;

//    新建用户信息
    void saveRole(Role role) throws Exception;

//    根据roleId查询role
    Role findById(String roleId) throws Exception;
//    查询出可以添加的权限
    List<Permission> findOtherPermissions(String roleId) throws Exception;
//    给角色添加权限
    void addPermissionToRole(String id, String[] permissionIds) throws Exception;
}
