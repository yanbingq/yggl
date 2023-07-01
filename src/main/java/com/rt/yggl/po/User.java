package com.rt.yggl.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private int userid;
    private String loginname;
    private String password;
    private String usertel;
    private String addres;
    private String realname;
    private String gender;
}
