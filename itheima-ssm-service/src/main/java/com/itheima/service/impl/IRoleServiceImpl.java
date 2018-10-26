package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.IRoleDao;
import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import com.itheima.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IRoleServiceImpl implements IRoleService{

    @Autowired
    private IRoleDao roleDao;

//    查询所有用户信息
    @Override
    public List<Role> findAllRole(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        List <Role> allRole = roleDao.findAllRole();
        return allRole;
    }

//    新建用户信息
    @Override
    public void saveRole(Role role) throws Exception {
        roleDao.saveRole(role);
    }

//    根据roleId查询role
    @Override
    public Role findById(String roleId) throws Exception {
        Role role= roleDao.findById(roleId);
        return role;
    }

//    查询出可以添加的权限
    @Override
    public List <Permission> findOtherPermissions(String roleId) throws Exception {

        return roleDao.findOtherPermissions(roleId);
    }

//    给角色添加权限信息
    @Override
    public void addPermissionToRole(String id, String[] permissionIds) throws Exception {
        for (String permissionId:permissionIds){
            roleDao.addPermissionToRole(id,permissionId);
        }
    }
}
