package com.bsty.icode.dao;

import com.bsty.icode.bean.Permission;
import com.bsty.icode.bean.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PermissionDao {

    List<RolePermission> getRolePermissions();

    List<Permission> findAll();

    List<Permission> findByRoleId(long roleId);

    List<Long> findIdsByRoleId(long roleId);

    List<String> findNamesByRoleId(long roleId);

    void addPermissions(@Param("roleId") long roleId, @Param("permissionIds") List<Long> permissionIds);

    void deleteByRoleId(long roleId);

    void deletePermissions(@Param("roleId") long roleId, @Param("permissionIds") List<Long> permissionIds);

}
