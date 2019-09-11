package com.bsty.icode.dao;

import com.bsty.icode.bean.HandInfo;
import com.bsty.icode.tk.TkMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HandInfoDao extends TkMapper<HandInfo> {
    void add(HandInfo info);
    int countCampus(String name);
    void addCampus(String name);
    int countChannel(String name);
    void addChannel(String name);
}
