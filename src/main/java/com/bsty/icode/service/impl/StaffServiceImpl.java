package com.bsty.icode.service.impl;

import com.bsty.icode.bean.Staff;
import com.bsty.icode.dao.StaffDao;
import com.bsty.icode.dto.StaffDTO;
import com.bsty.icode.service.StaffService;
import com.bsty.icode.smapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;
    @Autowired
    private StaffMapper staffMapper;

    public StaffServiceImpl() {
    }

    @Override
    public void addStaff(StaffDTO dto) {
        Staff staff = staffMapper.from(dto);
        staffDao.insertSelective(staff);
    }
}
