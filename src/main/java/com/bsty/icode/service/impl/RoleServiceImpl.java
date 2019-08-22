package com.bsty.icode.service.impl;

import com.bsty.icode.bean.Role;
import com.bsty.icode.dao.RoleDao;
import com.bsty.icode.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> findAll() {
        return roleDao.selectAll();
    }
}
