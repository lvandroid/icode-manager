package com.bsty.icode.controller;

import com.bsty.icode.ResponseData;
import com.bsty.icode.bean.CourseType;
import com.bsty.icode.dto.CourseTypeDTO;
import com.bsty.icode.service.CourseTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/api/courseType")
public class CourseTypeController {
    @Autowired
    private CourseTypeService courseTypeService;


    @PostMapping(value = "/add")
    public ResponseData add(@RequestBody CourseTypeDTO dto) {
        ResponseData responseData = ResponseData.newInstance();
        if (null != dto) {
            try {
                courseTypeService.addCourseType(dto);
                responseData.setSuccess();
            } catch (Exception e) {
                responseData.setError();
            }
        }
        return responseData;
    }

    @GetMapping(value = "/list")
    public ResponseData<List<CourseTypeDTO>> findAll() {
        ResponseData result = ResponseData.newInstance();
        try {
            List<CourseTypeDTO> dots = courseTypeService.findAll();
            result.setData(dots);
            result.setSuccess();
        } catch (Exception e) {
            result.setError();
        }
        return result;
    }

    @PostMapping(value = "/findByName")
    public ResponseData findByName(@RequestBody CourseTypeDTO dto) {
        ResponseData result = ResponseData.newInstance();
        try {
            List<CourseTypeDTO> dtos = courseTypeService.findByName(dto.getName());
            result.setData(dtos);
            result.setSuccess();
        } catch (Exception e) {
            result.setError();
        }
        return result;
    }

    @GetMapping(value = "/findByType")
    public ResponseData findByType(@RequestParam("type") int type) {
        ResponseData result = ResponseData.newInstance();
        try {
            CourseTypeDTO dto = courseTypeService.findByType(type);
            result.setData(dto);
            result.setSuccess();
        } catch (Exception e) {
            result.setError();
        }
        return result;
    }
}
