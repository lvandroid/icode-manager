package com.bsty.icode.controller;

import com.bsty.icode.ListResultData;
import com.bsty.icode.ResponseData;
import com.bsty.icode.bean.Genearch;
import com.bsty.icode.dto.GenearchDTO;
import com.bsty.icode.reqparams.GenearchParamDTO;
import com.bsty.icode.service.GenearchService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/api/genearch")
public class GenearchController {
    @Autowired
    private GenearchService genearchService;

    @PostMapping(value = "/add")
    public ResponseData addGenearch(@RequestBody GenearchDTO dto) {
        ResponseData responseData = ResponseData.newInstance();
        if (dto == null) {
            responseData.setErrMsg("传入参数有误");
        }
        Genearch genearch = new Genearch();

        try {
//            if (genearchService.isExist(genearch.getId())) {
//                responseData.setError("手机号已经存在");
//                return responseData;
//            }
            genearchService.addGenearch(genearch);
            responseData.setSuccess();
        } catch (Exception e) {
            responseData.setError();
        }
        return responseData;
    }

    @PostMapping(value = "/list")
    public ResponseData<List<GenearchDTO>> findStudents(@RequestBody GenearchParamDTO param) {
        Page page = PageHelper.startPage(param.getPageNum(), param.getPageSize());
        ResponseData responseData = ResponseData.newInstance();
        try {
            param.initSortMap();
            List<GenearchDTO> studentDTOS = genearchService.findByParams(param);
            ListResultData<GenearchDTO> result = new ListResultData<>();
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
}
