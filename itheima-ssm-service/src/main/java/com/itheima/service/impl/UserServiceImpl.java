package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.IUserDao;
import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        处理自己的用户对象封装成DetailsService对象
//        User user = new User(userInfo.getUsername(), "{noop}" + userInfo.getPassword(), this.getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUsername(),  userInfo.getPassword(),
                userInfo.getStatus()==0?false:true,true,true,true,
                getAuthority(userInfo.getRoles()));
        return user;
    }
    public List <SimpleGrantedAuthority> getAuthority(List <Role> roles) {
        List <SimpleGrantedAuthority> list = new ArrayList <>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

//    查询所有用户信息
    @Override
    public List <UserInfo> findAllUser(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return userDao.findAllUser();

    }

//    添加用户信息
    @Override
    public void saveUser(UserInfo userInfo) throws Exception {
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.saveUser(userInfo);
    }

//    查询用户的详情信息
    @Override
    public UserInfo findByIdUser(String id) throws Exception {
        UserInfo idUser = userDao.findByIdUser(id);
        return idUser;
    }

//    查询用户可以添加的角色
    @Override
    public List <Role> findOtherRoles(String id) throws Exception {
        List<Role> roles= userDao.findOtherRoles(id);
        return roles;
    }

//    给用户添加角色
    @Override
    public void addRoleToUser(String id, String[] roleIds) {
        for(String roleId:roleIds){
        userDao.addRoleToUser(id,roleId);
        }
    }
}
