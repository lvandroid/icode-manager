package com.bsty.icode.bean;


import lombok.Data;

import java.util.Date;

@Data
public class Student {

    private long id;
    private String name;
    private String phone;
    private String genearch;
    private String phoneSec;
    private String genearchSec;
    private String phoneOther;
    private String genearchOther;
    private String sex;
    private String idCard;
    private String wechat;
    private long birthday;
    private String school;
    private String grade;
    private String classNum;
    private String homeAddress;
    private String referPhone;
    private String mark;
    private long entryTime;
    private Date createTime;
    private Date updateTime;
    private long enable;

}
