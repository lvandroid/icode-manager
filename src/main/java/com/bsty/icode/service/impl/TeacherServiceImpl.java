package com.bsty.icode.service.impl;

import com.bsty.icode.bean.Teacher;
import com.bsty.icode.dao.TeacherDao;
import com.bsty.icode.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public void addTeacher(Teacher teacher) {
        if (teacher != null) {
            teacherDao.insertTeacher(teacher);
        }
    }

    @Override
    public List<Teacher> findAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        teachers.addAll(teacherDao.selectAllTeachers());
        return teachers;
    }
}
