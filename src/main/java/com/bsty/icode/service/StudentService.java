package com.bsty.icode.service;

import com.bsty.icode.bean.Student;
import com.bsty.icode.dto.StudentDTO;
import com.bsty.icode.reqparams.StudentParamDTO;

import java.util.List;

public interface StudentService {
    void addStudent(Student student) throws Exception;

    boolean isExist(String id) throws Exception;//是否已经存在

    List<StudentDTO> findByParams(StudentParamDTO param) throws Exception;
}
