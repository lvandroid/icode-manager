package com.bsty.icode.controller;

import com.bsty.icode.ListResultData;
import com.bsty.icode.ResponseData;
import com.bsty.icode.bean.CommunicateInfo;
import com.bsty.icode.bean.FollowStatus;
import com.bsty.icode.dto.FollowStatusVO;
import com.bsty.icode.dto.StudentDTO;
import com.bsty.icode.dto.StudentSchoolDTO;
import com.bsty.icode.dto.StudentVO;
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
        try {
//            if (studentService.isExist(dto.getId())) {
//                responseData.setError("手机号已经存在");
//                return responseData;
//            }
            studentService.addStudent(dto);
            responseData.setSuccess();
        } catch (Exception e) {
            responseData.setError();
            log.error(e.getMessage());
        }
        return responseData;
    }

    @PostMapping(value = "/list")
    public ResponseData<List<StudentVO>> findStudents(@RequestBody StudentParamDTO param) {
        Page page = PageHelper.startPage(param.getPageNum(), param.getPageSize());
        ResponseData responseData = ResponseData.newInstance();
        try {
            param.initSortMap();
            List<StudentVO> studentVOS = studentService.findByParams(param);
            ListResultData<StudentVO> result = new ListResultData<>();
            if (studentVOS != null && !studentVOS.isEmpty()) {
                result.setList(studentVOS);
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

    @PutMapping(value = "/updateStatus")
    public ResponseData updateFollowStatus(@RequestBody FollowStatusVO params) {
        ResponseData responseData = ResponseData.newInstance();
        try {
            if (params != null) {
                studentService.updateFollowStatus(params.getId(), params.getStatus());
                responseData.setSuccess();
            }
        } catch (Exception e) {
            responseData.setError();
            log.error(e.getMessage());
        }
        return responseData;
    }

    @PostMapping(value = "/addCommunicate")
    public ResponseData addCommunicate(@RequestBody CommunicateInfo params) {
        ResponseData responseData = ResponseData.newInstance();
        try {
            if (params != null) {
                params.setCreateTime(new Date().getTime());
                studentService.addCommunicateInfo(params);
                responseData.setSuccess();
            }
        } catch (Exception e) {
            responseData.setError();
            log.error(e.getMessage());
        }
        return responseData;
    }

    @GetMapping(value = "/getCommunicatesById/{studentId}")
    public ResponseData getCommunicatesById(@PathVariable  long studentId) {
        ResponseData responseData = ResponseData.newInstance();
        try {
            List<CommunicateInfo> data = studentService.findCommunicatesById(studentId);
            responseData.setSuccess(data);
        } catch (Exception e) {
            responseData.setError();
            log.error(e.getMessage());
        }
        return responseData;
    }
}
