package com.bsty.icode.dto;

import lombok.Data;

@Data
public class CourseDTO {
    private long id; //课程ID
    private String name; //课程名称
    private long startDate; //开课日期
    private long endDate; //结课日期
    private long teacherId; //老师ID
    private int courseSum; //课时数
    private long courseTypeId;//课程类型id
    private double totalPrice; //总价
    private double unitPrice; //单价
    private String actName; //活动名称
    private int actCourseSum; //活动课时数
    private double actTotalPrice; //活动总价
    private double actUnitPrice; //活动单价
    private String classRef;//课程参考年级
    private String mark;//备注
}
