package com.bsty.icode.dao;

import com.bsty.icode.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
//    @Select("SELECT * FROM user WHERE username= #{username}")
    User findUserByName(@Param("username") String username);
}
