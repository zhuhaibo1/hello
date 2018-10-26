package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.IPermissionsDao;
import com.itheima.domain.Permission;
import com.itheima.domain.Product;
import com.itheima.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private IPermissionsDao permissionsDao;

//    查询所有资源权限
    @Override
    public List <Permission> findAllPermission(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        List <Permission> product = permissionsDao.findAllPermission();
        return product;
    }

//    添加资源权限
    @Override
    public void savePermission(Permission permission) throws Exception{
        permissionsDao.savePermission(permission) ;
    }
}
