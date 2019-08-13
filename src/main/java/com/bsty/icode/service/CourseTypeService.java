package com.bsty.icode.service;

import com.bsty.icode.bean.CourseType;
import com.bsty.icode.dto.CourseTypeDTO;

import java.util.List;

public interface CourseTypeService {
    void addCourseType(CourseTypeDTO dto) throws Exception;

    List<CourseTypeDTO> findAll() throws Exception;

    List<CourseTypeDTO> findByName(String name) throws Exception;

    CourseTypeDTO findByType(int type) throws Exception;
}
