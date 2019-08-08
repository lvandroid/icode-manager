package com.bsty.icode.service;

import com.bsty.icode.bean.Teacher;

import java.util.List;

public interface TeacherService {
    void addTeacher(Teacher teacher);
    List<Teacher> findAllTeachers();
}
