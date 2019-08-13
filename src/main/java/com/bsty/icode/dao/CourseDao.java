package com.bsty.icode.dao;

import com.bsty.icode.bean.Course;
import com.bsty.icode.dto.CourseParamDTO;
import com.bsty.icode.request.CourseVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseDao {
    void insertCourse(Course course);

    List<CourseVO> selectAllCourses();

    List<CourseVO> selectCourseByParams(CourseParamDTO params);
}
