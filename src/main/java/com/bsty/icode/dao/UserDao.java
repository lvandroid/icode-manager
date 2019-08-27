package com.bsty.icode.dao;

import com.bsty.icode.bean.User;
import com.bsty.icode.dto.UserDTO;
import com.bsty.icode.reqparams.UserParamDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {
    //    @Select("SELECT * FROM user WHERE username= #{username}")
    User findUserByName(@Param("username") String username);

    long findRoleRootId(long userId);

    long addUser(User user);

    void delUser(long userId);

    String findUserRoleNames(long userId);

    List<UserDTO> selectByParams(UserParamDTO params);

    void updatePwd(@Param("userId") long userId, @Param("pwd") String pwd);
}
