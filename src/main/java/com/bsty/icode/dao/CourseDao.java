package com.bsty.icode.dao;

import com.bsty.icode.bean.Course;
import com.bsty.icode.dto.CourseParamDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseDao {
    void insertCourse(Course course);

    List<Course> selectAllCourses();

    List<Course> selectCourseByParams(CourseParamDTO params);
}
