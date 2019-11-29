package com.bsty.icode.service;

import com.bsty.icode.bean.CommunicateInfo;
import com.bsty.icode.bean.FollowInfo;
import com.bsty.icode.bean.HandInfo;
import com.bsty.icode.bean.Student;
import com.bsty.icode.dto.StudentDTO;
import com.bsty.icode.dto.StudentSchoolDTO;
import com.bsty.icode.dto.StudentVO;
import com.bsty.icode.reqparams.StudentParamDTO;

import java.util.List;

public interface StudentService {
    void addStudent(StudentDTO student) throws Exception;

    void addCommunicateInfo(CommunicateInfo info);

    List<CommunicateInfo> findCommunicatesById(long studentId);

    void addFollowInfo(FollowInfo info);

    void addHandInfo(HandInfo info);

    boolean isExist(long id) throws Exception;//是否已经存在

    List<StudentVO> findByParams(StudentParamDTO param) throws Exception;

    StudentSchoolDTO findAllStudentSchoolInfo() throws Exception;

    void updateFollowStatus(long studentId, String status);
}
