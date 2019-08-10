package com.bsty.icode.controller;

import com.bsty.icode.ResponseData;
import com.bsty.icode.request.CourseDTO;
import com.bsty.icode.service.CourseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseData<List<CourseDTO>> getCourseList(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize) {
        Page page = PageHelper.startPage(pageNum, pageSize);
        ResponseData responseData = ResponseData.newInstance();
        try {
            responseData.setData(courseService.findAllCourse());
            responseData.setSuccess();
            responseData.setTotal(page.getTotal());
        } catch (Exception e) {
            responseData.setError();
            log.error(e.getMessage());
        }
        return responseData;
    }
}
