package com.bsty.icode.service.impl;

import com.bsty.icode.bean.Permission;
import com.bsty.icode.dao.PermissionDao;
import com.bsty.icode.dao.RoleDao;
import com.bsty.icode.dao.UserDao;
import com.bsty.icode.service.AuthService;
import com.bsty.icode.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PermissionDao permissionDao;
    @Autowired
    private UserDao userDao;

    @Override
    public String login(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        String token = jwtTokenUtil.generateToken(userDetails);
        return token;
    }

    @Override
    public long findRoleByUserId(long userId) {
        return userDao.findRoleRootId(userId);
    }

    @Override
    public List<String> findUserPermission(long rootRoleId) {
        return permissionDao.findNamesByRoleId(rootRoleId);
    }
}
