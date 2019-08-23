package com.bsty.icode.dao;

import com.bsty.icode.bean.Router;
import com.bsty.icode.tk.TkMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RouterDao extends TkMapper<Router> {
    List<Router> findByType(int type);

    List<Router> findAsync();

    List<Router> findByRoleId(long roleId);

    List<Long> findIdsByRoleId(long roleId);

    void addRoleId(@Param("roleId") long roleId, @Param("routeIds") List<Long> routeIds);

    void deleteByRoleId(long roleId);

}
