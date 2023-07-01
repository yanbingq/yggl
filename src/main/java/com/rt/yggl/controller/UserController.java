package com.rt.yggl.controller;


import com.rt.yggl.anno.JwtAnno;
import com.rt.yggl.po.User;
import com.rt.yggl.po.Role;
import com.rt.yggl.service.UserService;
import com.rt.yggl.util.JwtUtils;
import com.rt.yggl.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
@Slf4j
@Component
public class UserController {
    @Autowired
    UserService service;
    @Resource
    Jedis jedis;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResult login(@RequestBody LoginView loginView) {
        jedis.set("loginname", loginView.getUsername());
        User user = service.findOneByLoginName(loginView.getUsername());
        UserRole userRole = service.findUserRole(loginView.getUsername());
        BaseResult result = new BaseResult();
        if (!ObjectUtils.isEmpty(user) && loginView.getPassword().equals(user.getPassword())) {
            String token = JwtUtils.gettoken(user.getLoginname(), userRole.getRoleid());
            log.info("token==" + token);
            loginView.setPassword(null);
            result.setCode(200);
            result.setMsg("ok");
            result.setData(token);
        } else {
            result.setCode(-200);
            result.setData(null);
            result.setMsg("no");
        }
        return result;
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.POST)
    public BaseResult userInfo(@RequestBody LoginView loginView) {
        UserInfo info = service.findUserInfo(loginView.getUsername());
        log.info(loginView.getUsername());
        BaseResult result = new BaseResult();
        if (!ObjectUtils.isEmpty(info)) {
            result.setCode(200);
            result.setMsg("ok");
            result.setData(info);
        } else {
            result.setCode(-200);
            result.setData(null);
            result.setMsg("no");
        }
        return result;
    }


    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public BaseResult updateUser(@RequestBody User user) {
        boolean b = service.updateUser(user);
        BaseResult result = new BaseResult();
        if (b) {
            UserInfo info = service.findUserInfo(user.getLoginname());
            result.setCode(200);
            result.setMsg("ok");
            result.setData(info);
        } else {
            result.setCode(-200);
            result.setMsg("no");
            result.setData(null);
        }

        return result;
    }


    @RequestMapping(value = "/savepwd", method = RequestMethod.POST)
    public BaseResult savePass(@RequestBody UpUserpass userpass) {
        BaseResult result = new BaseResult();
        User user = service.findOneByLoginName(userpass.getLoginname());
        if (!ObjectUtils.isEmpty(user) && user.getPassword().equals(userpass.getPwd())) {
            boolean b = service.savePass(userpass);
            result.setCode(200);
            result.setMsg("update ok");
            result.setData(null);
        } else {
            result.setCode(-200);
            result.setMsg("原密码不正确！");
            result.setData(null);
        }
        return result;
    }

    @RequestMapping("/findAll")
    public BaseResult findAll() {
        List<UserInfo> all = service.findAll();
        BaseResult result = new BaseResult();
        result.setCode(200);
        result.setMsg("ok");
        result.setData(all);
        return result;
    }

    @JwtAnno(name = "开除员工")
    @RequestMapping(value = "/delUser", method = RequestMethod.POST)
    public BaseResult delUser(@RequestBody User user) {
        boolean b = service.delUser(user.getUserid());
        boolean b1 = service.delUserRole(user.getUserid());
        BaseResult result = new BaseResult();
        if (b) {
            result.setCode(200);
            result.setMsg("ok");
            result.setData(null);
        } else {
            result.setCode(-200);
            result.setMsg("no");
            result.setData(null);
        }

        return result;
    }

    @JwtAnno(name = "修改员工权限")
    @RequestMapping(value = "/upUserRole", method = RequestMethod.POST)
    public BaseResult upUserRole(@RequestBody Role role) {
        boolean b = service.upUserRole(role);
        BaseResult result = new BaseResult();
        if (b) {
            result.setCode(200);
            result.setMsg("ok");
            result.setData(null);
        } else {
            result.setCode(-200);
            result.setMsg("no");
            result.setData(null);
        }

        return result;
    }

    @JwtAnno(name = "添加新员工信息")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public BaseResult addUser(@RequestBody User user) {
        user.setPassword("1234");
        User User = service.addUser(user);
        BaseResult result = new BaseResult();
        result.setCode(200);
        result.setMsg("ok");
        result.setData(User);
        return result;
    }

    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    public BaseResult addRole(@RequestBody Role role) {
        boolean b = service.addRole(role);
        BaseResult result = new BaseResult();
        if (b) {
            result.setCode(200);
            result.setMsg("ok");
            result.setData(null);
        } else {
            result.setCode(-200);
            result.setMsg("no");
            result.setData(null);
        }

        return result;
    }

    @RequestMapping(value = "/userRole", method = RequestMethod.POST)
    public BaseResult UserRole(@RequestBody LoginView loginView) {
        UserRole userRole = service.findUserRole(loginView.getUsername());
        BaseResult result = new BaseResult();
        if (!ObjectUtils.isEmpty(userRole) && userRole.getRoleid() < 3) {
            result.setCode(200);
            result.setMsg("ok");
            result.setData(null);
        }
        if (!ObjectUtils.isEmpty(userRole) && userRole.getRoleid() == 3) {

            result.setCode(-200);
            result.setMsg("ok");
            result.setData(null);
        }
        return result;
    }
}
