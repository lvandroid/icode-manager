package com.bsty.icode.service.impl;

import com.bsty.icode.dao.CourseDao;
import com.bsty.icode.dto.CourseDTO;
import com.bsty.icode.reqparams.CourseParamDTO;
import com.bsty.icode.request.CourseVO;
import com.bsty.icode.service.CourseService;
import com.bsty.icode.smapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public void addCourse(CourseDTO dto) {
        if (dto!= null) {
            courseDao.insertCourse(courseMapper.from(dto));
        }
    }

    @Override
    public List<CourseVO> findAllCourse() {
        List<CourseVO> courses = courseDao.selectAllCourses();
//        List<CourseDTO> courseDTOS = new ArrayList<>();
//        if (courses != null && !courses.isEmpty()) {
//            for (Course course : courses) {
//                courseDTOS.add(new CourseDTO(course));
//            }
//        }
        return courses;
    }

    @Override
    public List<CourseVO> findCourseByParams(CourseParamDTO params) {
        List<CourseVO> courses = courseDao.selectCourseByParams(params);
        return courses;
    }
}
