package com.rt.yggl.service;

import com.rt.yggl.po.Notice;

public interface NoticeService {
    Notice findNotice();

    int updateNotice();

    int addNotice(Notice notice);
}
