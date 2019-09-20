package com.bsty.icode.dao;

import com.bsty.icode.bean.*;
import com.bsty.icode.dto.StudentDTO;
import com.bsty.icode.dto.StudentVO;
import com.bsty.icode.reqparams.StudentParamDTO;
import com.bsty.icode.tk.TkMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentDao extends TkMapper<Student> {
    void add(Student student);

//    int selectCount(long id);

    List<Student> selectAll();

    List<StudentVO> selectByParams(StudentParamDTO param);

    void updateFollowStatus(long studentId, String status);

    void addFollowInfoStatus(long studentId, String status);

    void addGenearch(String name);

    List<Genearch> allGenearch();

    int countGenearch(String name);

    void addCampus(String name);

    List<Campus> allCampus();

    int countCampus(String name);

    void addChannel(String name);

    List<Channel> allChannel();

    int countChannel(String name);

    void addConsultType(String name);

    List<ConsultType> allConsultType();

    int countConsultType(String name);

    void addFollowStatus(String name);

    List<FollowStatus> allFollowStatus();

    int countFollowStatus(String name);

    void addGrade(String name);

    List<Grade> allGrade();

    int countGrade(String name);

    void addIntention(String name);

    List<Intention> allIntention();

    int countIntention(String name);

    void addkeyword(String name);

    List<Keyword> allKeyword();

    int countKeyword(String name);

    void addCourseType(String name);

    List<CourseType> allCourseType();

    int countCourseType(String name);
}
