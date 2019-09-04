package com.bsty.icode.dao;

import com.bsty.icode.bean.*;
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

    void addGenearch(String name);
    List<Genearch> allGenearch();
    void addCampus(String name);
    List<Campus> allCampus();
    void addChannel(String name);
    List<Channel> allChannel();
    void addConsultType(String name);
    List<ConsultType> allConsultType();
    void addFollowStatus(String name);
    List<FollowStatus> allFollowStatus();
    void addGrade(String name);
    List<Grade> allGrade();
    void addIntention(String name);
    List<Intention> allIntention();
    void addkeyword(String name);
    List<Keyword> allKeyword();
    void addCourseType(String name);
    List<CourseType> allCourseType();
}
