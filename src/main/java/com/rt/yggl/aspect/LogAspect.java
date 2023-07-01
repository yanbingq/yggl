package com.rt.yggl.aspect;

import com.rt.yggl.anno.JwtAnno;
import com.rt.yggl.po.Log;
import com.rt.yggl.po.User;
import com.rt.yggl.service.UserService;
import com.rt.yggl.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect

public class LogAspect {

    @Autowired
    LogService logService;
    @Autowired
    UserService userService;
    @Autowired
    HttpServletRequest request;
    @Resource
    Jedis jedis;

    @Pointcut("@annotation(com.rt.yggl.anno.JwtAnno)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String loginname = jedis.get("loginname");
        User one = userService.findOneByLoginName(loginname);
        int userid = 2;
        if (!ObjectUtils.isEmpty(one)) {
            userid = one.getUserid();
        }

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        JwtAnno anno = method.getAnnotation(JwtAnno.class);
        Log Log = new Log();
        if (anno != null) {
            Log.setLogName(anno.name());
            Log.setLogTime(new Date());
            Log.setLogId(0);
            Log.setLogUserId(userid);
            Log.setUserIp(request.getRemoteAddr());
            logService.addLogg(Log);
        }
        return joinPoint.proceed();
    }
}
