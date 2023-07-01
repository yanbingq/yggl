package com.rt.yggl.controller;

import com.rt.yggl.po.Log;
import com.rt.yggl.po.User;
import com.rt.yggl.service.UserService;
import com.rt.yggl.service.LogService;
import com.rt.yggl.vo.BaseResult;
import com.rt.yggl.vo.LogInfo;
import com.rt.yggl.vo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api")
@RestController
public class LogController {
    @Autowired
    LogService logService;
    @Autowired
    UserService userService;

    @RequestMapping("/logAll")
    public BaseResult findAll() {
        List<Log> all = logService.findAll();
        BaseResult baseResult = new BaseResult();
        baseResult.setMsg("ok");
        baseResult.setCode(200);
        baseResult.setData(all);
        return baseResult;
    }

    @RequestMapping(value = "/logByInfo", method = RequestMethod.POST)
    public BaseResult findByLog(@RequestBody LogInfo info) {
        User user = userService.findByReanlname(info.getRealname());
        if (!ObjectUtils.isEmpty(user)) {
            info.setUserId(user.getUserid());
        }
        List<Log> byInfo = logService.findLogByInfo(info);
        System.out.println(byInfo);
        for (Log log : byInfo) {
            User byId = userService.findById(log.getLogUserId());
            if (!ObjectUtils.isEmpty(byId)) {
                log.setRealname(byId.getRealname());
                System.out.println(log);
            }
        }
        BaseResult baseResult = new BaseResult();
        baseResult.setMsg("ok");
        baseResult.setCode(200);
        baseResult.setData(byInfo);
        return baseResult;
    }
}
