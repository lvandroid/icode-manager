package com.bsty.icode.service.impl;

import com.bsty.icode.bean.Role;
import com.bsty.icode.dao.PermissionDao;
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
    private PermissionDao permissionDao;
    @Autowired
    private RoleMapper roleMapper;

    public RoleServiceImpl() {
    }

    @Override
    public List<RoleDTO> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void addRole(RoleDTO dto, List<Long> routerIds, List<Long> permissionIds) {
        Role role = roleMapper.from(dto);
        roleDao.addRole(role);
        long roleId = role.getId();
        if (routerIds != null && !routerIds.isEmpty()) {
            routerDao.addRouters(roleId, routerIds);
        }
        if (permissionIds != null && !permissionIds.isEmpty()) {
            permissionDao.addPermissions(roleId, permissionIds);
        }
    }

    @Override
    public void delRole(long roleId) {
        routerDao.deleteByRoleId(roleId);
        permissionDao.deleteByRoleId(roleId);
        roleDao.delById(roleId);
    }

    @Override
    public void updateRole(RoleDTO dto) {
        roleDao.updateRole(roleMapper.from(dto));
    }

    @Override
    public void delUserRole(long userId) {
        roleDao.delUserRole(userId);
    }
}
