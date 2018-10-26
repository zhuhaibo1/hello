package com.itheima.service;

import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

//    @查询所有用户信息
    public List<UserInfo> findAllUser(int page,int size) throws Exception;
//    添加用户信息
    void saveUser(UserInfo userInfo) throws Exception;
//    根据id值查询用户的详情信息
    UserInfo findByIdUser(String id) throws Exception;
//    查询用户可以添加的角色
    List<Role> findOtherRoles(String id) throws Exception;
//    给用户添加角色
    void addRoleToUser(String id, String[] roleIds);
}
