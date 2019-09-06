package com.bsty.icode.service.impl;

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
//            student.setId(student.getId());
//            studentDao.insert(student);
            studentDao.insert(student);
            long id = student.getId();
            String className = student.getClassNum();
            String school = student.getSchool();
            String genearch = student.getGenearch();
            String genearchSec = student.getGenearchSec();
            String genearchOther = student.getGenearchOther();
            String grade = student.getGrade();
            if (studentDao.countGenearch(genearch) < 1) {
                studentDao.addGenearch(genearch);
            }
            if (studentDao.countGenearch(genearchSec) < 1) {
                studentDao.addGenearch(genearchSec);
            }
            if (studentDao.countGenearch(genearchOther) < 1) {
                studentDao.addGenearch(genearchOther);
            }
            if (schoolDao.countSchool(school) < 1) {
                schoolDao.addSchool(school);
            }
            if (studentDao.countGrade(grade) < 1) {
                studentDao.addGrade(grade);
            }
            if (classNameDao.countClassName(className) < 1) {
                classNameDao.addClassName(className);
            }
        }
    }

    @Override
    public boolean isExist(long id) throws Exception {
//        if (studentDao.selectCount(id) > 0) {
//            return true;
//        }
        return false;
    }

    @Override
    public List<StudentDTO> findByParams(StudentParamDTO param) throws Exception {
        List<StudentDTO> dtos = studentDao.selectByParams(param);
        for (StudentDTO dto : dtos) {
            dto.setEntryTime(dto.getCreateTime().getTime() / 1000);
        }
        return dtos;
    }

    @Override
    public StudentSchoolDTO findAllStudentSchoolInfo() throws Exception {
        StudentSchoolDTO dto = new StudentSchoolDTO();
        dto.setSchools(schoolDao.selectAll());
        dto.setClassNames(classNameDao.selectAll());
        dto.setGrades(studentDao.allGrade());
        dto.setGenearches(studentDao.allGenearch());
        dto.setHomeAddresses(homeAddressDao.selectAll());
        dto.setCampuses(studentDao.allCampus());
        dto.setChannels(studentDao.allChannel());
        dto.setConMethods(studentDao.allConsultType());
        dto.setCourses(studentDao.allCourseType());
        dto.setIntentions(studentDao.allIntention());
        dto.setKeywords(studentDao.allKeyword());
        dto.setFollowStatuses(studentDao.allFollowStatus());
        return dto;
    }
}
