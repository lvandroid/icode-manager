package com.bsty.icode.service;

import com.bsty.icode.request.CourseDTO;

import java.util.List;

public interface CourseService {
    void addCourse(CourseDTO courseRequest);

    List<CourseDTO> findAllCourse();
}
