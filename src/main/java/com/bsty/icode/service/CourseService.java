package com.bsty.icode.service;

import com.bsty.icode.dto.CourseDTO;
import com.bsty.icode.reqparams.CourseParamDTO;
import com.bsty.icode.request.CourseVO;

import java.util.List;

public interface CourseService {
    void addCourse(CourseDTO courseRequest);

    List<CourseVO> findAllCourse();

    List<CourseVO> findCourseByParams(CourseParamDTO params);
}
