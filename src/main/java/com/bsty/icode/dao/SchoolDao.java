package com.bsty.icode.dao;

import com.bsty.icode.bean.School;
import com.bsty.icode.tk.TkMapper;

import java.util.List;

public interface SchoolDao extends TkMapper<School> {
    List<String> selectAllName();
}
