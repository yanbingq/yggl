package com.rt.yggl.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogInfo implements Serializable {
    private String realname;
    private Date date1;
    private Date date2;
    private int userId;
}
