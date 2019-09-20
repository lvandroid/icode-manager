package com.bsty.icode.dto;

import lombok.Data;

@Data
public class StudentVO {
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
    private String className;
    private String homeAddress;
    private String referPhone;
    private String mark;
    private long entryTime; //录入时间
    private long createTime;
    private long updateTime;
    private long enable;
    private String consultMethod; //咨询方式
    private String intention;//意向度
    //    private List<String> courses;
    private String courseStr;
    private String followStatus;//跟进状态
    private String keyword;//关键词
    private long revisitRemind;//回访提醒
    private String communicateContent;//沟通内容
    private String campus;//校区
    private String channel;//渠道
    private String clerk;//采单员
    private String salesman;//销售员
    private String telemarketer;//电话销售员
}
