package com.rt.yggl.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfo implements Serializable {
    private int orderid;
    private int comname;
    private Date date1;
    private Date date2;
}
