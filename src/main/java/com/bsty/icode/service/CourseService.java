package com.bsty.icode.service;

import com.bsty.icode.bean.Course;
import com.bsty.icode.dto.CourseParamDTO;
import com.bsty.icode.request.CourseVO;

import java.util.List;

public interface CourseService {
    void addCourse(CourseVO courseRequest);

    List<Course> findAllCourse();

    List<Course> findCourseByParams(CourseParamDTO params);
}
