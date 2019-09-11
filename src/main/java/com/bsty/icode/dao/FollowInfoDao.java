package com.bsty.icode.dao;

import com.bsty.icode.bean.FollowInfo;
import com.bsty.icode.tk.TkMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FollowInfoDao extends TkMapper<FollowInfo> {
    void add(FollowInfo info);
    int countConsultMethod(String name);

    void addConsultMethod(String name);

    int countIntention(String name);

    void addIntention(String name);

    int countStatus(String name);

    void addStatus(String name);

    int countKeyword(String name);

    void addKeyword(String name);
}
