package com.bsty.icode.service.impl;

import com.bsty.icode.bean.Student;
import com.bsty.icode.dao.StudentDao;
import com.bsty.icode.dto.StudentDTO;
import com.bsty.icode.reqparams.StudentParamDTO;
import com.bsty.icode.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public void addStudent(Student student) throws Exception {
        if (student != null) {
            student.setId(student.getPhone());
            studentDao.insertStudent(student);
        }
    }

    @Override
    public boolean isExist(String id) throws Exception {
        if (studentDao.selectCount(id) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<StudentDTO> findByParams(StudentParamDTO param) throws Exception {
        return studentDao.selectByParams(param);
    }
}
