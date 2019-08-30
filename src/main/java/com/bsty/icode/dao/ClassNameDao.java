package com.bsty.icode.dao;

import com.bsty.icode.bean.ClassName;
import com.bsty.icode.tk.TkMapper;

import java.util.List;

public interface ClassNameDao extends TkMapper<ClassName> {
    List<String> selectAllName();

}
