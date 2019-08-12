package com.bsty.icode.controller;

import com.bsty.icode.ListResultData;
import com.bsty.icode.ResponseData;
import com.bsty.icode.bean.Course;
import com.bsty.icode.dto.CourseParamDTO;
import com.bsty.icode.request.CourseVO;
import com.bsty.icode.service.CourseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/api")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping(value = "/course/add")
    public ResponseData addCourse(@RequestBody CourseVO courseVO) {
        ResponseData responseData = ResponseData.newInstance();
        if (courseVO != null) {
            courseService.addCourse(courseVO);
            responseData.setSuccess();
        }
        return responseData;
    }

    @GetMapping(value = "/course/list")
    public ResponseData<List<CourseVO>> findAllCourse() {
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

    @PostMapping(value = "/course/getCourseList")
    public ResponseData<ListResultData<CourseVO>> getCourseList(@RequestBody @NotNull CourseParamDTO params) {
        Page page = PageHelper.startPage(params.getPageNum(), params.getPageSize());
        ResponseData responseData = ResponseData.newInstance();
        try {
            params.initSortMap();
            List<Course> courses = courseService.findCourseByParams(params);
            List<CourseVO> courseVOS = new ArrayList<>();
            ListResultData<CourseVO> result = new ListResultData();

            if (courses != null && !courses.isEmpty()) {
                for (Course course : courses) {
                    courseVOS.add(new CourseVO(course));
                }
                result.setList(courseVOS);
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
