package com.rt.yggl.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpUserpass implements Serializable {
    private String pwd;
    private String loginname;
    private String password;
}
