package com.bsty.icode.dao;

import com.bsty.icode.bean.RolePermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionDao {

    List<RolePermission> getRolePermissions();
}
