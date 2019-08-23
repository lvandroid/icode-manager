package com.bsty.icode.service;

import com.bsty.icode.bean.Role;
import com.bsty.icode.dto.RoleDTO;

import java.util.List;

public interface RoleService {
    List<RoleDTO> findAll();
    void addRole(RoleDTO dto,List<Long> routerIds);
    void delRole(long roleId);
    void updateRole(RoleDTO dto);
}
