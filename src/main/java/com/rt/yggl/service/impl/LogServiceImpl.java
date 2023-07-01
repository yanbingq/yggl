package com.rt.yggl.service.impl;

import com.rt.yggl.mapper.LogMapper;
import com.rt.yggl.po.Log;
import com.rt.yggl.service.LogService;
import com.rt.yggl.vo.LogInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Resource
    LogMapper logMapper;

    @Override
    public boolean addLogg(Log log) {
        int i = logMapper.addLog(log);
        if (i > -1) return true;
        return false;
    }

    @Override
    public List<Log> findAll() {
        List<Log> all = logMapper.findAll();
        return all;
    }

    @Override
    public List<Log> findLogByInfo(LogInfo info) {
        List<Log> logByInfo = logMapper.findLogByInfo(info);
        return logByInfo;
    }
}
