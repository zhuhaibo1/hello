package com.itheima.service;

import com.itheima.domain.Permission;

import java.util.List;

public interface PermissionService {
//    查询所有资源权限
    List<Permission> findAllPermission(int page, int size)throws Exception;

//    添加资源权限
    void savePermission(Permission permission) throws Exception;
}
