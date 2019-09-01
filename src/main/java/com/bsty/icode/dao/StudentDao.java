package com.bsty.icode.dao;

import com.bsty.icode.bean.Student;
import com.bsty.icode.dto.StudentDTO;
import com.bsty.icode.reqparams.StudentParamDTO;
import com.bsty.icode.tk.TkMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentDao extends TkMapper<Student> {
//    void insert(Student student);

//    int selectCount(long id);

    List<Student> selectAll();

    List<StudentDTO> selectByParams(StudentParamDTO param);
}
