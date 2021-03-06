package com.bsty.icode.bean;

import lombok.Data;

import java.util.List;

@Data
public class Teacher {
    private long id;
    private String name;
    private long updateDate;
    private long entryDate;
    private String phone;
    private List<Long> courseTypeIds; //教授课程类型
    private int sex;
    private String mark;
}
