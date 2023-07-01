package com.rt.yggl.mapper;

import com.rt.yggl.po.Notice;

public interface NoticeMapper {
    Notice findNotice();

    int updateNotice();

    int addNotice(Notice notice);
}
