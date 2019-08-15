package com.bsty.icode.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentDTO {
    private String id;
    private String phone;
    private String name;
    private int sex;
    private String grade;
    private String genearchId; //家长id
    private String genearchName; //家长姓名
    private String genearchPhone; //家长手机号
    private String genearchRelation; //家长关系
    private List<Long> courseIds;// 已经报名的课程ID
    private String courseNames; //已经报名的课程
    private String mark;
    private boolean enable;//是否激活，报名课程成功为激活
    private String referId;//推荐人id
}
