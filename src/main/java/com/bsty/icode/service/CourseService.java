package com.bsty.icode.service;

import com.bsty.icode.bean.Course;
import com.bsty.icode.request.CourseDTO;

import java.util.List;

public interface CourseService {
    void addCourse(CourseDTO courseRequest);

    List<Course> findAllCourse();
}
