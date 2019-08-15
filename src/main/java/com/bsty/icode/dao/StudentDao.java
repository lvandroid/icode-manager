package com.bsty.icode.dao;

import com.bsty.icode.bean.Student;
import com.bsty.icode.dto.StudentDTO;
import com.bsty.icode.reqparams.StudentParamDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentDao {
    void insertStudent(Student student);

    int selectCount(String id);

    List<Student> selectAll();

    List<StudentDTO> selectByParams(StudentParamDTO param);
}
