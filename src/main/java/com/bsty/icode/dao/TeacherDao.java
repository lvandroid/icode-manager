package com.bsty.icode.dao;

import com.bsty.icode.bean.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherDao {
    void insertTeacher(Teacher teacher);
    List<Teacher> selectAllTeachers();
}
