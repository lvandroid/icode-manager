package com.bsty.icode.service;

import com.bsty.icode.bean.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> getPermissionList();

    List<Permission> findAsyncPermission();

    List<Permission> findByRoleId(long roleId);

    List<Long> findAllIdsByByRoleId(long roleId);

    void deleteByRoleId(long roleId);

    void addPermissions(long roleId, List<Long> permissionIds);

    void deletePermissions(long roleId, List<Long> permissionIds);
}
