package com.bsty.icode.controller;

import com.bsty.icode.ListResultData;
import com.bsty.icode.ResponseData;
import com.bsty.icode.bean.Course;
import com.bsty.icode.request.CourseDTO;
import com.bsty.icode.service.CourseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping(value = "/api")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping(value = "/course/add")
    public ResponseData addCourse(@RequestBody CourseDTO courseDTO) {
        ResponseData responseData = ResponseData.newInstance();
        if (courseDTO != null) {
            courseService.addCourse(courseDTO);
            responseData.setSuccess();
        }
        return responseData;
    }

    @GetMapping(value = "/course/list")
    public ResponseData<List<CourseDTO>> findAllCourse() {
        ResponseData responseData = ResponseData.newInstance();
        try {
            responseData.setData(courseService.findAllCourse());
            responseData.setSuccess();
        } catch (Exception e) {
            responseData.setError();
            log.error(e.getMessage());
        }
        return responseData;
    }

    @GetMapping(value = "/course/getCourseList")
    public ResponseData<ListResultData<CourseDTO>> getCourseList(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize, Map<String,String> params) {
        Page page = PageHelper.startPage(pageNum, pageSize);
        ResponseData responseData = ResponseData.newInstance();
        try {
            List<Course> courses = courseService.findAllCourse();
            List<CourseDTO> courseDTOS = new ArrayList<>();
            ListResultData<CourseDTO> result = new ListResultData();

            if (courses != null && !courses.isEmpty()) {
                for (Course course : courses) {
                    courseDTOS.add(new CourseDTO(course));
                }
                result.setList(courseDTOS);
            }
            result.setPageNum(page.getPageNum());
            result.setPageSize(page.getPageSize());
            result.setTotal(page.getTotal());
            responseData.setData(result);
            responseData.setSuccess();
            responseData.setTotal(page.getTotal());
        } catch (Exception e) {
            responseData.setError();
            log.error(e.getMessage());
        }
        return responseData;
    }
}
