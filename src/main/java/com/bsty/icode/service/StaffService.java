package com.bsty.icode.service;

import com.bsty.icode.dto.StaffDTO;
import com.bsty.icode.reqparams.StaffParamsDTO;

import java.util.List;

public interface StaffService {
    void addStaff(StaffDTO dto);
    List<StaffDTO> orderById();
    List<StaffDTO> getAll();
    List<StaffDTO> getList(StaffParamsDTO dto);
}
