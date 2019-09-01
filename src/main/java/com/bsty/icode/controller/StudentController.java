package com.bsty.icode.controller;

import com.bsty.icode.ListResultData;
import com.bsty.icode.ResponseData;
import com.bsty.icode.bean.Student;
import com.bsty.icode.dto.StudentDTO;
import com.bsty.icode.dto.StudentSchoolDTO;
import com.bsty.icode.reqparams.StudentParamDTO;
import com.bsty.icode.service.StudentService;
import com.bsty.icode.smapper.StudentMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentMapper studentMapper;

    @PostMapping(value = "/add")
    public ResponseData addStudent(@RequestBody StudentDTO dto) {
        ResponseData responseData = ResponseData.newInstance();
        if (dto == null) {
            responseData.setErrMsg("传入参数有误");
        }
        Student student = studentMapper.from(dto);
        try {
//            if (studentService.isExist(dto.getId())) {
//                responseData.setError("手机号已经存在");
//                return responseData;
//            }
            studentService.addStudent(student);
            responseData.setSuccess();
        } catch (Exception e) {
            responseData.setError();
            log.error(e.getMessage());
        }
        return responseData;
    }

    @PostMapping(value = "/list")
    public ResponseData<List<StudentDTO>> findStudents(@RequestBody StudentParamDTO param) {
        Page page = PageHelper.startPage(param.getPageNum(), param.getPageSize());
        ResponseData responseData = ResponseData.newInstance();
        try {
            param.initSortMap();
            List<StudentDTO> studentDTOS = studentService.findByParams(param);
            ListResultData<StudentDTO> result = new ListResultData<>();
            if (studentDTOS != null && !studentDTOS.isEmpty()) {
                result.setList(studentDTOS);
            }
            result.setPage(page);
            responseData.setSuccess(result, page.getTotal());
        } catch (Exception e) {
            log.error(e.getMessage());
            responseData.setError();
        }
        return responseData;
    }

    @GetMapping(value = "/studentSchoolInfos")
    public ResponseData<StudentSchoolDTO> getStudentSchoolInfos() {
        ResponseData responseData = ResponseData.newInstance();
        try {
            responseData.setSuccess(studentService.findAllStudentSchoolInfo());
        } catch (Exception e) {
            log.error(e.getMessage());
            responseData.setError();
        }
        return responseData;
    }
}
