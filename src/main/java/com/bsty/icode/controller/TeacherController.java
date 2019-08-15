package com.bsty.icode.controller;

import com.bsty.icode.ListResultData;
import com.bsty.icode.ResponseData;
import com.bsty.icode.bean.Teacher;
import com.bsty.icode.dto.TeacherDTO;
import com.bsty.icode.reqparams.TeacherParamDTO;
import com.bsty.icode.service.TeacherService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/api")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping(value = "/teacher/add")
    public ResponseData addTeacher(@RequestBody TeacherDTO dto) {
        ResponseData responseData = ResponseData.newInstance();
        try {
            if (dto != null) {
                Teacher teacher = new Teacher();
                teacher.setName(dto.getName());
                teacher.setSex(dto.getSex());
                teacher.setMark(dto.getMark());
                teacher.setPhone(dto.getPhone());
                teacher.setEntryDate(dto.getEntryDate());
                long teacherId = teacherService.addTeacher(teacher);
                teacherService.addTeacherCourseType(teacherId, dto.getCourseTypeIds());
                responseData.setSuccess();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            responseData.setError();
        }

        return responseData;
    }

    @PostMapping(value = "/teacher/list")
    public ResponseData<List<TeacherDTO>> findAllTeachers(@RequestBody TeacherParamDTO params) {
        Page page = PageHelper.startPage(params.getPageNum(), params.getPageSize());
        ResponseData responseData = ResponseData.newInstance();
        try {
            params.initSortMap();
            List<TeacherDTO> teacherDTOS = teacherService.findByParams(params);
            ListResultData<TeacherDTO> result = new ListResultData<>();
            if (teacherDTOS != null && !teacherDTOS.isEmpty()) {
                result.setList(teacherDTOS);
            }
            result.setPage(page);
            responseData.setData(result);
            responseData.setTotal(page.getTotal());
            responseData.setSuccess();
        } catch (Exception e) {
            log.error(e.getMessage());
            responseData.setError();
        }
        return responseData;
    }
}
