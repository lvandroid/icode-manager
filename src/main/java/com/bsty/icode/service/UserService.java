package com.bsty.icode.service;

import com.bsty.icode.dto.UserDTO;
import com.bsty.icode.reqparams.UserParamDTO;
import com.bsty.icode.request.UserVo;

import java.util.List;

public interface UserService {
    void addUser(UserVo vo);
    List<UserDTO> getAll(UserParamDTO params);
    List<Long> getRoles(long userId);
    long getRootRole(long userId);
    void delUser(long userId);
    void updatePwd(long userId, String pwd);
    void updateUserRoles(UserVo vo);
}
