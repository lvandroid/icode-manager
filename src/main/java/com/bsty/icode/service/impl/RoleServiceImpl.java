package com.bsty.icode.service.impl;

import com.bsty.icode.bean.Role;
import com.bsty.icode.dao.RoleDao;
import com.bsty.icode.dao.RouterDao;
import com.bsty.icode.dto.RoleDTO;
import com.bsty.icode.service.RoleService;
import com.bsty.icode.smapper.RoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private RouterDao routerDao;
    @Autowired
    private RoleMapper roleMapper;

    public RoleServiceImpl() {
    }

    @Override
    public List<RoleDTO> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void addRole(RoleDTO dto, List<Long> routerIds) {
        Role role = roleMapper.from(dto);
        roleDao.addRole(role);
        long roleId = role.getId();
        routerDao.addRouters(roleId, routerIds);
    }

    @Override
    public void delRole(long roleId) {
        routerDao.deleteByRoleId(roleId);
        roleDao.delById(roleId);
    }

    @Override
    public void updateRole(RoleDTO dto) {
        roleDao.updateRole(roleMapper.from(dto));
    }
}
