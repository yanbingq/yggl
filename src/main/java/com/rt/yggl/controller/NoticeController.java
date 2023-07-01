package com.rt.yggl.controller;

import com.rt.yggl.po.Notice;
import com.rt.yggl.service.NoticeService;
import com.rt.yggl.vo.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    @RequestMapping("/findNotice")
    public BaseResult findNotice() {
        Notice all = noticeService.findNotice();
        BaseResult baseResult = new BaseResult();
        baseResult.setMsg("ok");
        baseResult.setData(all);
        baseResult.setCode(200);
        return baseResult;
    }

    @RequestMapping(value = "/addNotice", method = RequestMethod.POST)
    public BaseResult addNOtice(@RequestBody Notice notice) {
        int i = noticeService.updateNotice();
        BaseResult baseResult = new BaseResult();
        if (i > -1) {
            notice.setNoTime(new Date());
            int i1 = noticeService.addNotice(notice);
            if (i1 > -1) {
                baseResult.setMsg("ok");
                baseResult.setData(notice);
                baseResult.setCode(200);
            }
        } else {
            baseResult.setMsg("ok");
            baseResult.setData(notice);
            baseResult.setCode(-200);
        }
        return baseResult;
    }
}
