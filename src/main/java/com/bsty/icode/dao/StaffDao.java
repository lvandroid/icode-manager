package com.bsty.icode.dao;

import com.bsty.icode.bean.Staff;
import com.bsty.icode.dto.StaffDTO;
import com.bsty.icode.tk.TkMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StaffDao extends TkMapper<Staff> {
}
