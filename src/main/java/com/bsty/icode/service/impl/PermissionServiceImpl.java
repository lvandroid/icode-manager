package com.bsty.icode.service.impl;

import com.bsty.icode.bean.Permission;
import com.bsty.icode.dao.PermissionDao;
import com.bsty.icode.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> getPermissionList() {
        return permissionDao.findAll();
    }

    @Override
    public List<Permission> findAsyncPermission() {
        return permissionDao.findAll();
    }

    @Override
    public List<Permission> findByRoleId(long roleId) {
        return permissionDao.findByRoleId(roleId);
    }

    @Override
    public List<Long> findAllIdsByByRoleId(long roleId) {
        return permissionDao.findIdsByRoleId(roleId);
    }

    @Override
    public void deleteByRoleId(long roleId) {
        permissionDao.deleteByRoleId(roleId);
    }

    @Override
    public void addPermissions(long roleId, List<Long> permissionIds) {
        if (permissionIds != null && !permissionIds.isEmpty()) {
            permissionDao.addPermissions(roleId, permissionIds);
        }
    }

    @Override
    public void deletePermissions(long roleId, List<Long> permissionIds) {
        permissionDao.deletePermissions(roleId, permissionIds);
    }
}
