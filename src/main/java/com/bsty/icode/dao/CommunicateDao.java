package com.bsty.icode.dao;

import com.bsty.icode.bean.CommunicateInfo;
import com.bsty.icode.tk.TkMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunicateDao extends TkMapper<CommunicateInfo> {
    void add(CommunicateInfo info);

    List<CommunicateInfo> findCommunicatesById(long studentId);
}
