package com.bsty.icode.controller;

import com.bsty.icode.ResponseData;
import com.bsty.icode.dto.StaffDTO;
import com.bsty.icode.service.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        }catch (Exception e){
            responseData.setError();
        }
        return responseData;
    }
}
