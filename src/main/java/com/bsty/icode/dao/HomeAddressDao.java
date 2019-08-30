package com.bsty.icode.dao;

import com.bsty.icode.bean.HomeAddress;
import com.bsty.icode.tk.TkMapper;

import java.util.List;

public interface HomeAddressDao extends TkMapper<HomeAddress> {
    List<String> selectAllName();

}
