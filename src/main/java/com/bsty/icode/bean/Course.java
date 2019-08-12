package com.bsty.icode.bean;

import com.bsty.icode.request.CourseVO;
import lombok.Data;

@Data
public class Course {
    private long id; //课程ID
    private String name; //课程名称
    private long startDate; //开课日期
    private long endDate; //结课日期
    private long teacherId; //老师ID
    private int courseSum; //课时数
    private double totalPrice; //总价
    private double unitPrice; //单价
    private String actName; //活动名称
    private int actCourseSum; //活动课时数
    private double actTotalPrice; //活动总价
    private double actUnitPrice; //活动单价
    private String classRef;//课程参考年级
    private String mark;//备注

    public Course(CourseVO dto) {
        if (dto == null) return;
        this.name = dto.getName();
        this.startDate = dto.getStartDate();
        this.endDate = dto.getEndDate();
        this.courseSum = dto.getCourseSum();
        this.totalPrice = dto.getTotalPrice();
        this.unitPrice = dto.getUnitPrice();
        this.actName = dto.getActName();
        this.actCourseSum = dto.getActCourseSum();
        this.actTotalPrice = dto.getActTotalPrice();
        this.actUnitPrice = dto.getActUnitPrice();
        this.classRef = dto.getClassRef();
        this.mark = dto.getMark();
    }

    public Course() {
    }
}
