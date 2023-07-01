package com.rt.yggl.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRole implements Serializable {
    private int userid;
    private String loginname;
    private String password;
    private String usertel;
    private String addres;
    private String realname;
    private String gender;
    private int roleid;
}
