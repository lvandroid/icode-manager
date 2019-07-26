package com.bsty.icode.dao;

import com.bsty.icode.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {
    //    @Select("SELECT * FROM user WHERE name = #{name}")
    List<User> findUserByName(@Param("name") String name);

    void insertUser(@Param("user") User user);
}
