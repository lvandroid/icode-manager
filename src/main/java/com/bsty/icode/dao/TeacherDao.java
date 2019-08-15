package com.bsty.icode.dao;

import com.bsty.icode.bean.Teacher;
import com.bsty.icode.dto.TeacherDTO;
import com.bsty.icode.reqparams.TeacherParamDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherDao {
    void insertTeacher(Teacher teacher);

    List<Teacher> selectAllTeachers();

    List<TeacherDTO> selectCourseByParams(TeacherParamDTO params);

    void insertTeacherCourseType(@Param("teacherId") long teacherId, @Param("courseTypeIds") List<Long> courseTypeIds);

}
