package com.rt.yggl.mapper;

import com.rt.yggl.po.Log;
import com.rt.yggl.vo.LogInfo;

import java.util.List;

public interface LogMapper {

    int addLog(Log log);

    List<Log> findAll();

    List<Log> findLogByInfo(LogInfo info);


}
