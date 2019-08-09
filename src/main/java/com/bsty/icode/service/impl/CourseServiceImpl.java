package com.bsty.icode.service.impl;

import com.bsty.icode.bean.Course;
import com.bsty.icode.dao.CourseDao;
import com.bsty.icode.request.CourseDTO;
import com.bsty.icode.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

    @Override
    public void addCourse(CourseDTO courseDTO) {
        if (courseDTO != null) {
            courseDao.insertCourse(new Course(courseDTO));
        }
    }

    @Override
    public List<CourseDTO> findAllCourse() {
        List<Course> courses = courseDao.selectAllCourses();
        List<CourseDTO> courseDTOS = new ArrayList<>();
        if (courses != null && !courses.isEmpty()) {
            for (Course course : courses) {
                courseDTOS.add(new CourseDTO(course));
            }
        }
        return courseDTOS;
    }
}
