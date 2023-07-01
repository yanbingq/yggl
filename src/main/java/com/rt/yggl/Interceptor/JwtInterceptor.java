package com.rt.yggl.Interceptor;

import com.rt.yggl.config.JwtConfig;
import com.rt.yggl.util.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    private static final Logger logger = Logger.getLogger(JwtConfig.class.getName());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        logger.info(token);
        boolean b;
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        b = token != null && JwtUtils.checktoken(token);
        return b;
    }
}
