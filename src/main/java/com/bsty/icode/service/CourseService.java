package com.bsty.icode.service;

import com.bsty.icode.reqparams.CourseParamDTO;
import com.bsty.icode.request.CourseVO;

import java.util.List;

public interface CourseService {
    void addCourse(CourseVO courseRequest);

    List<CourseVO> findAllCourse();

    List<CourseVO> findCourseByParams(CourseParamDTO params);
}
