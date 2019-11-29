package com.bsty.icode.service;

import java.util.List;

public interface AuthService {
    String login(String username, String password);

    long findRoleByUserId(long userId);

    long findStaffIdByUserId(long userId);

    /**
     * 根据主要角色查询用户拥有的权限
     *
     * @param rootRoleId
     * @return
     */
    List<String> findUserPermission(long rootRoleId);
}
