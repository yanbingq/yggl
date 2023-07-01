package com.rt.yggl.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice implements Serializable {
    private int id;
    private String noAction;
    private Date noTime;
}
