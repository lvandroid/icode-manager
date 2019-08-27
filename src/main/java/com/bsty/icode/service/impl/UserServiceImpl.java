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
            long rootRoleId = user.getRootRoleId();
            List<Long> roleIds = vo.getRoleIds();
            if (roleIds != null && !roleIds.isEmpty()) {
                roleDao.addUser(userId, roleIds, rootRoleId);
            }
        }
    }

    @Override
    public List<UserDTO> getAll(UserParamDTO params) {
        List<UserDTO> dtos = userDao.selectByParams(params);
        if (dtos != null && !dtos.isEmpty()) {
            for (UserDTO dto : dtos) {
                dto.setRoleNames(userDao.findUserRoleNames(dto.getId()));
            }
        }
        return dtos;
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
}
