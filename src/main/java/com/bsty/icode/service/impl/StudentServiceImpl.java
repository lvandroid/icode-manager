package com.bsty.icode.service.impl;

import com.bsty.icode.bean.CommunicateInfo;
import com.bsty.icode.bean.FollowInfo;
import com.bsty.icode.bean.HandInfo;
import com.bsty.icode.bean.Student;
import com.bsty.icode.dao.*;
import com.bsty.icode.dto.StudentDTO;
import com.bsty.icode.dto.StudentSchoolDTO;
import com.bsty.icode.dto.StudentVO;
import com.bsty.icode.reqparams.StudentParamDTO;
import com.bsty.icode.service.StudentService;
import com.bsty.icode.smapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
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
    @Autowired
    private CommunicateDao communicateDao;
    @Autowired
    private FollowInfoDao followInfoDao;
    @Autowired
    private HandInfoDao handInfoDao;
    @Autowired
    StudentMapper studentMapper;

    @Override
    public void addStudent(StudentDTO dto) throws Exception {
        if (dto != null) {
            Student student = studentMapper.from(dto);
            studentDao.add(student);
            long id = student.getId();
            addExtras(dto);
            CommunicateInfo communicateInfo = dto.getCommunicate(id);
            if (communicateInfo != null) {
                communicateDao.add(communicateInfo);
            }
            FollowInfo followInfo = dto.getFollowInfo(id);
            if (followInfo != null) {
                followInfoDao.add(followInfo);
            }
            HandInfo handInfo = dto.getHandInfo(id);
            if (handInfo != null) {
                handInfoDao.add(handInfo);
            }
        }
    }

    private void addExtras(StudentDTO student) {
        if (student == null) return;
        String className = student.getClassName();
        String school = student.getSchool();
        String genearch = student.getGenearch();
        String genearchSec = student.getGenearchSec();
        String genearchOther = student.getGenearchOther();
        String grade = student.getGrade();
        String consultMethod = student.getConsultMethod();
        String intent = student.getIntention();
        String followStatus = student.getFollowStatus();
        String keyword = student.getKeyword();
        String campus = student.getCampus();
        String channel = student.getChannel();
        if (genearch != null && !genearch.isEmpty() && studentDao.countGenearch(genearch) < 1) {
            studentDao.addGenearch(genearch);
        }
        if (genearchSec != null && !genearchSec.isEmpty() && studentDao.countGenearch(genearchSec) < 1) {
            studentDao.addGenearch(genearchSec);
        }
        if (genearchOther != null && !genearchOther.isEmpty() && studentDao.countGenearch(genearchOther) < 1) {
            studentDao.addGenearch(genearchOther);
        }
        if (school != null && !school.isEmpty() && schoolDao.countSchool(school) < 1) {
            schoolDao.addSchool(school);
        }
        if (grade != null && !grade.isEmpty() && studentDao.countGrade(grade) < 1) {
            studentDao.addGrade(grade);
        }
        if (className != null && !className.isEmpty() && classNameDao.countClassName(className) < 1) {
            classNameDao.addClassName(className);
        }
        if (consultMethod != null && !consultMethod.isEmpty() && followInfoDao.countConsultMethod(consultMethod) < 1) {
            followInfoDao.addConsultMethod(consultMethod);
        }
        if (intent != null && !intent.isEmpty() && followInfoDao.countIntention(intent) < 1) {
            followInfoDao.addIntention(intent);
        }
        if (followStatus != null && !followStatus.isEmpty() && followInfoDao.countStatus(followStatus) < 1) {
            followInfoDao.addStatus(followStatus);
        }
        if (keyword != null && !keyword.isEmpty() && followInfoDao.countKeyword(keyword) < 1) {
            followInfoDao.addKeyword(keyword);
        }
        if (campus != null && !campus.isEmpty() && handInfoDao.countCampus(campus) < 1) {
            handInfoDao.addCampus(campus);
        }
        if (channel != null && !channel.isEmpty() && handInfoDao.countChannel(channel) < 1) {
            handInfoDao.addChannel(channel);
        }
    }

    @Override
    public void addCommunicateInfo(CommunicateInfo info) {
        if (info != null) {
            communicateDao.add(info);
        }
    }

    @Override
    public List<CommunicateInfo> findCommunicatesById(long studentId) {
        return communicateDao.findCommunicatesById(studentId);
    }

    @Override
    public void addFollowInfo(FollowInfo info) {
        if (info != null) {
            followInfoDao.insert(info);
        }
    }

    @Override
    public void addHandInfo(HandInfo info) {
        if (info != null) {
            handInfoDao.insert(info);
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
    public List<StudentVO> findByParams(StudentParamDTO param) throws Exception {
        List<StudentVO> dtos = studentDao.selectByParams(param);
        for (StudentVO dto : dtos) {
            dto.setEntryTime(dto.getCreateTime());
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

    @Override
    public void updateFollowStatus(long studentId, String status) {
        if (followInfoDao.hasFollowInfo(studentId) > 0) {
            studentDao.updateFollowStatus(studentId, status);
        } else {
            studentDao.addFollowInfoStatus(studentId, status, new Date().getTime());
        }
    }
}
