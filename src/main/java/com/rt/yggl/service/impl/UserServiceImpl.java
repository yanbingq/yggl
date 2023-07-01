package com.rt.yggl.service.impl;

import com.rt.yggl.mapper.UserMapper;
import com.rt.yggl.po.User;
import com.rt.yggl.po.Role;
import com.rt.yggl.service.UserService;
import com.rt.yggl.vo.UpUserpass;
import com.rt.yggl.vo.UserInfo;
import com.rt.yggl.vo.UserRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public User findOneByLoginName(String loginName) {
        User user = userMapper.findOneByLoginName(loginName);
        return user;
    }

    @Override
    public UserInfo findUserInfo(String loginName) {
        UserInfo info = userMapper.findUserInfo(loginName);
        return info;
    }

    @Override
    public UserRole findUserRole(String loginName) {
        UserRole userRole = userMapper.findUserRole(loginName);
        return userRole;
    }

    @Override
    public boolean updateUser(User user) {
        int i = userMapper.updateUser(user);
        if (i > -1) return true;
        return false;
    }


    @Override
    public boolean savePass(UpUserpass userpass) {
        int i = userMapper.savepass(userpass);
        if (i > -1) return true;
        return false;
    }

    @Override
    public List<UserInfo> findAll() {
        List<UserInfo> all = userMapper.findAll();
        return all;
    }

    @Override
    public boolean delUser(int id) {
        int i = userMapper.delUser(id);
        if (i > -1) return true;
        return false;
    }

    @Override
    public boolean delUserRole(int id) {
        int i = userMapper.delUserRole(id);
        if (i > -1) return true;
        return false;
    }

    @Override
    public boolean upUserRole(Role role) {
        int i = userMapper.upUserRole(role);
        if (i > -1) return true;
        return false;
    }

    @Override
    public User addUser(User user) {
        int i = userMapper.addUser(user);
        if (i > -1) return user;
        return null;
    }

    @Override
    public boolean addRole(Role role) {
        int i = userMapper.addRole(role);
        if (i > -1) return true;
        return false;
    }

    @Override
    public User findByReanlname(String name) {
        User user = userMapper.findByReanlname(name);
        return user;
    }

    @Override
    public User findById(int id) {
        User byId = userMapper.findById(id);
        return byId;
    }

}
