package com.bsty.icode.service.impl;

import com.bsty.icode.bean.HomeAddress;
import com.bsty.icode.bean.Student;
import com.bsty.icode.dao.ClassNameDao;
import com.bsty.icode.dao.HomeAddressDao;
import com.bsty.icode.dao.SchoolDao;
import com.bsty.icode.dao.StudentDao;
import com.bsty.icode.dto.StudentDTO;
import com.bsty.icode.dto.StudentSchoolDTO;
import com.bsty.icode.reqparams.StudentParamDTO;
import com.bsty.icode.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private SchoolDao schoolDao;
    @Autowired
    private HomeAddressDao homeAddressDao;
    @Autowired
    private ClassNameDao classNameDao;

    @Override
    public void addStudent(Student student) throws Exception {
        if (student != null) {
            student.setId(student.getId());
            studentDao.insert(student);
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

    @Override
    public StudentSchoolDTO findAllStudentSchoolInfo() throws Exception {
        StudentSchoolDTO dto = new StudentSchoolDTO();
        dto.setSchools(schoolDao.selectAllName());
        dto.setClassNames(classNameDao.selectAllName());
        dto.setHomeAddresses(homeAddressDao.selectAllName());
        return dto;
    }
}
