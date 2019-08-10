package com.bsty.icode.request;

import com.bsty.icode.bean.Course;
import lombok.Data;

@Data
public class CourseDTO {
    private String name; //课程名称
    private long startDate; //开课日期
    private long endDate; //结课日期
    private int courseSum; //课时数
    private double totalPrice; //总价
    private double unitPrice; //单价
    private String actName; //活动名称
    private int actCourseSum; //活动课时数
    private double actTotalPrice; //活动总价
    private double actUnitPrice; //活动单价
    private String classRef;//课程参考年级
    private String mark;//备注

    public CourseDTO(Course course) {
        if (course == null) return;
        this.name = course.getName();
        this.startDate = course.getStartDate();
        this.endDate = course.getEndDate();
        this.courseSum = course.getCourseSum();
        this.totalPrice = course.getTotalPrice();
        this.unitPrice = course.getUnitPrice();
        this.actName = course.getActName();
        this.actCourseSum = course.getActCourseSum();
        this.actTotalPrice = course.getActTotalPrice();
        this.actUnitPrice = course.getActUnitPrice();
        this.classRef = course.getClassRef();
        this.mark = course.getMark();
    }

    public CourseDTO() {
    }
}
