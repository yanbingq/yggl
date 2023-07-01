package com.rt.yggl.service.impl;

import com.rt.yggl.mapper.NoticeMapper;
import com.rt.yggl.po.Notice;
import com.rt.yggl.service.NoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Resource
    NoticeMapper noticeMapper;

    @Override
    public Notice findNotice() {
        Notice all = noticeMapper.findNotice();
        return all;
    }

    @Override
    public int updateNotice() {
        int i = noticeMapper.updateNotice();

        return i;
    }

    @Override
    public int addNotice(Notice notice) {
        int i = noticeMapper.addNotice(notice);
        return i;
    }
}
