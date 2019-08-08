package com.bsty.icode.controller;

import com.bsty.icode.ResponseData;
import com.bsty.icode.bean.Teacher;
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
    public ResponseData addTeacher(@RequestBody AddTeacherRequest addTeacherRequest) {
        ResponseData responseData = ResponseData.newInstance();
        if (addTeacherRequest != null) {
            Teacher teacher = new Teacher();
            teacher.setName(addTeacherRequest.getName());
            teacher.setSex(addTeacherRequest.getSex());
            teacherService.addTeacher(teacher);
            responseData.setSuccess();
        }
        return responseData;
    }

    @GetMapping(value = "/teacher/list")
    public ResponseData<List<Teacher>> findAllTeachers() {
        ResponseData responseData = ResponseData.newInstance();
        try {
            responseData.setData(teacherService.findAllTeachers());
            responseData.setSuccess();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return responseData;
    }
}
