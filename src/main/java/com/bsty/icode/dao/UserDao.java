package com.bsty.icode.dao;

import com.bsty.icode.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {
    //    @Select("SELECT * FROM user WHERE name = #{name}")
    User findUserByName(@Param("username") String username);
}
