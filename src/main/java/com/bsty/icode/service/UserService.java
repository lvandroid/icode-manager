package com.bsty.icode.service;

import com.bsty.icode.bean.User;
import com.bsty.icode.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> selectUserByName(String name) {
        return userDao.findUserByName(name);
    }

    public void addUser(User user){
        userDao.insertUser(user);
    }

}
