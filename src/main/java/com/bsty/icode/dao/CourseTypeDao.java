package com.bsty.icode.dao;

import com.bsty.icode.bean.CourseType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseTypeDao {
    void insert(CourseType courseType);
    CourseType findByType(int type);
    List<CourseType> findByName(String name);
    List<CourseType> findAll();
}
