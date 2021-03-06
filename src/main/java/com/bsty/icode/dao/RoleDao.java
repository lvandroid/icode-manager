package com.bsty.icode.dao;

import com.bsty.icode.bean.Role;
import com.bsty.icode.dto.RoleDTO;
import com.bsty.icode.tk.TkMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleDao extends TkMapper<Role> {
    List<Role> getRolesByUserId(@Param("userId") Long userId);

    long addRole(Role role);

    void delById(long id);

    List<RoleDTO> findAll();

    void updateRole(Role role);

    void addUser(@Param("userId") long userId, @Param("roleIds") List<Long> roleIds);

    void addUserRootRole(@Param("userId") long userId, @Param("rootRoleId") long rootRoleId);

    void delUserRole(long userId);
}
