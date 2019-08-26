package com.bsty.icode.controller;

import com.bsty.icode.ListResultData;
import com.bsty.icode.ResponseData;
import com.bsty.icode.dto.StaffDTO;
import com.bsty.icode.reqparams.StaffParamsDTO;
import com.bsty.icode.service.StaffService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping(value = "/api/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping(value = "/add")
    public ResponseData addStaff(@RequestBody StaffDTO dto) {
        ResponseData responseData = ResponseData.newInstance();
        try {
            staffService.addStaff(dto);
            responseData.setSuccess(null, 0);
        } catch (Exception e) {
            responseData.setError();
            log.error(e.getMessage());
        }
        return responseData;
    }

    @PostMapping(value = "/list")
    public ResponseData getStaffs(@RequestBody StaffParamsDTO dto) {
        Page page = PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        ResponseData responseData = ResponseData.newInstance();
        try {
//            List<StaffDTO> result = staffService.orderById();
            ListResultData<StaffDTO> result = new ListResultData<>();
            result.setList(staffService.getList(dto));
            result.setPage(page);
            responseData.setSuccess(result, page.getTotal());
        } catch (Exception e) {
            responseData.setError();
            log.error(e.getMessage());
        }
        return responseData;
    }

}
