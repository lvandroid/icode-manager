package com.bsty.icode.service.impl;

import com.bsty.icode.bean.User;
import com.bsty.icode.dao.RoleDao;
import com.bsty.icode.dao.UserDao;
import com.bsty.icode.dto.UserDTO;
import com.bsty.icode.reqparams.UserParamDTO;
import com.bsty.icode.request.UserVo;
import com.bsty.icode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public void addUser(UserVo vo) {
        if (vo != null) {
            User user = new User(vo.getUsername(), vo.getPassword());
            userDao.addUser(user);
            long userId = user.getId();
            long rootRoleId = vo.getRootRoleId();
            List<Long> roleIds = vo.getRoleIds();
            roleDao.addUserRootRole(userId, rootRoleId);
            roleDao.addUser(userId, roleIds);
        }
    }

    @Override
    public List<UserDTO> getAll(UserParamDTO params) {
        List<UserDTO> dtos = userDao.selectByParams(params);
        return dtos;
    }

    @Override
    public List<Long> getRoles(long userId) {
        return userDao.findUserRoles(userId);
    }

    @Override
    public long getRootRole(long userId) {
        return userDao.findUserRootId(userId);
    }

    @Override
    public void delUser(long userId) {
        userDao.delUser(userId);
        roleDao.delUserRole(userId);
    }

    @Override
    public void updatePwd(long userId, String pwd) {
        userDao.updatePwd(userId, pwd);
    }

    @Override
    public void updateUserRoles(UserVo vo) {
        if (vo == null) return;
        roleDao.delUserRole(vo.getId());
        roleDao.addUserRootRole(vo.getId(), vo.getRootRoleId());
        roleDao.addUser(vo.getId(), vo.getRoleIds());
    }
}
