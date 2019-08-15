package com.bsty.icode.service.impl;

import com.bsty.icode.bean.Teacher;
import com.bsty.icode.dao.TeacherDao;
import com.bsty.icode.dto.TeacherDTO;
import com.bsty.icode.reqparams.TeacherParamDTO;
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
    public long addTeacher(Teacher teacher) {
        long id = 0;
        if (teacher != null) {
            teacherDao.insertTeacher(teacher);
            id = teacher.getId();
        }
        return id;
    }

    @Override
    public void addTeacherCourseType(long teacherId, List<Long> courseTypeIds) {
        teacherDao.insertTeacherCourseType(teacherId,courseTypeIds);
    }

    @Override
    public List<Teacher> findAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        teachers.addAll(teacherDao.selectAllTeachers());
        return teachers;
    }

    @Override
    public List<TeacherDTO> findByParams(TeacherParamDTO paramDTO) throws Exception {
        return  teacherDao.selectCourseByParams(paramDTO);
    }

}
