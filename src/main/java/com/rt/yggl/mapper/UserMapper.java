package com.rt.yggl.mapper;

import com.rt.yggl.po.User;
import com.rt.yggl.po.Role;
import com.rt.yggl.vo.UpUserpass;
import com.rt.yggl.vo.UserInfo;
import com.rt.yggl.vo.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    User findOneByLoginName(@Param("name") String loginName);

    UserInfo findUserInfo(@Param("name") String loginName);

    UserRole findUserRole(@Param("name") String loginName);

    int updateUser(User user);

    int savepass(UpUserpass userpass);

    List<UserInfo> findAll();

    int delUser(@Param("id") int id);

    int delUserRole(@Param("id") int id);

    int upUserRole(Role role);

    int addUser(User user);

    int addRole(Role role);

    User findByReanlname(@Param("name") String name);

    User findById(@Param("id") int id);

}
