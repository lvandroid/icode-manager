package com.bsty.icode.service;

public interface AuthService {
    String login( String username, String password );
    long findRoleByUserId(long userId);
}
