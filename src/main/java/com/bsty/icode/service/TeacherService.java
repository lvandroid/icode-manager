package com.bsty.icode.service;

import com.bsty.icode.bean.Teacher;

import java.util.List;

public interface TeacherService {
    long addTeacher(Teacher teacher) throws Exception;

    void addTeacherCourseType(long teacherId, List<Long> courseTypeIds) throws Exception;

    List<Teacher> findAllTeachers() throws Exception;
}
