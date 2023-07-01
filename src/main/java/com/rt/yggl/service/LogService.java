package com.rt.yggl.service;

import com.rt.yggl.po.Log;
import com.rt.yggl.vo.LogInfo;

import java.util.List;

public interface LogService {

    boolean addLogg(Log log);

    List<Log> findAll();

    List<Log> findLogByInfo(LogInfo info);
}
