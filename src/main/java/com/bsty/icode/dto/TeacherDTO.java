package com.bsty.icode.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeacherDTO {
    private long id;
    private String name;
    private long entryDate;
    private List<Long> courseTypeIds; //教授课程类型ID
    private String courseTypeNames; //教授课程类型名称
    private int sex;
    private long courseId; //精确查找
    private String courseName;
    private String mark;
}
