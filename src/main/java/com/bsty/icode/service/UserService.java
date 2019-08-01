package com.bsty.icode.service;

import com.bsty.icode.bean.User;
import com.bsty.icode.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    public User selectUserByName(String name) {
        return userDao.findUserByName(name);
    }

    public void addUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //根据用户名从数据库查询对应记录
        User user = userDao.findUserByName(s);
        if (user == null) {
            throw new UsernameNotFoundException("username is not exists");
        }
        return user;
    }
}
