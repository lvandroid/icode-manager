package com.bsty.icode.service.impl;

import com.bsty.icode.bean.CourseType;
import com.bsty.icode.dao.CourseTypeDao;
import com.bsty.icode.dto.CourseTypeDTO;
import com.bsty.icode.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseTypeServiceImpl implements CourseTypeService {
    @Autowired
    CourseTypeDao courseTypeDao;

    @Override
    public void addCourseType(CourseTypeDTO dto) {
        if (dto != null) ;
        courseTypeDao.insert(new CourseType(dto));
    }

    @Override
    public List<CourseTypeDTO> findAll() {
        return beanToDtoList(courseTypeDao.findAll());
    }

    @Override
    public List<CourseTypeDTO> findByName(String name) {
        return beanToDtoList(courseTypeDao.findByName(name));
    }

    @Override
    public CourseTypeDTO findByType(int type) {
        return new CourseTypeDTO(courseTypeDao.findByType(type));
    }

    private List<CourseTypeDTO> beanToDtoList(List<CourseType> beans) {
        List<CourseTypeDTO> dtos = new ArrayList<>();
        if (beans != null && !beans.isEmpty()) {
            for (CourseType bean : beans) {
                dtos.add(new CourseTypeDTO(bean));
            }
        }
        return dtos;
    }
}
