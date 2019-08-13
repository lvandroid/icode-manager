package com.bsty.icode.service.impl;

import com.bsty.icode.bean.Course;
import com.bsty.icode.dao.CourseDao;
import com.bsty.icode.dto.CourseParamDTO;
import com.bsty.icode.request.CourseVO;
import com.bsty.icode.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

    @Override
    public void addCourse(CourseVO courseVO) {
        if (courseVO != null) {
            courseDao.insertCourse(new Course(courseVO));
        }
    }

    @Override
    public List<Course> findAllCourse() {
        List<Course> courses = courseDao.selectAllCourses();
//        List<CourseDTO> courseDTOS = new ArrayList<>();
//        if (courses != null && !courses.isEmpty()) {
//            for (Course course : courses) {
//                courseDTOS.add(new CourseDTO(course));
//            }
//        }
        return courses;
    }

    @Override
    public List<Course> findCourseByParams(CourseParamDTO params) {
        List<Course> courses = courseDao.selectCourseByParams(params);
        return courses;
    }
}