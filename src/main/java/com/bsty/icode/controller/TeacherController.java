package com.bsty.icode.controller;

import com.bsty.icode.ResponseData;
import com.bsty.icode.bean.Teacher;
import com.bsty.icode.dto.TeacherDTO;
import com.bsty.icode.dto.TeacherParamDTO;
import com.bsty.icode.request.AddTeacherRequest;
import com.bsty.icode.service.TeacherService;
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
    public ResponseData<List<TeacherDTO>> findAllTeachers(@RequestBody TeacherParamDTO paramDTO) {
        ResponseData responseData = ResponseData.newInstance();
        try {
            responseData.setData(teacherService.findByParams(paramDTO));
            responseData.setSuccess();
        } catch (Exception e) {
            log.error(e.getMessage());
            responseData.setError();
        }
        return responseData;
    }
}
