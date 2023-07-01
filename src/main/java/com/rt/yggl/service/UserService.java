package com.rt.yggl.service;

import com.rt.yggl.po.User;
import com.rt.yggl.po.Role;
import com.rt.yggl.vo.UpUserpass;
import com.rt.yggl.vo.UserInfo;
import com.rt.yggl.vo.UserRole;

import java.util.List;

public interface UserService {
    User findOneByLoginName(String loginName);

    UserInfo findUserInfo(String loginName);

    UserRole findUserRole(String loginName);

    boolean updateUser(User user);

    boolean savePass(UpUserpass userpass);

    List<UserInfo> findAll();

    boolean delUser(int id);

    boolean delUserRole(int id);

    boolean upUserRole(Role role);

    User addUser(User user);

    boolean addRole(Role role);

    User findByReanlname(String name);

    User findById(int id);

}
