package com.bsty.icode.controller;

import com.bsty.icode.ResponseData;
import com.bsty.icode.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    /**
     * 登录
     */
    @PostMapping(value = "/auth/login")
    public ResponseData<String> login(String username, String password) throws AuthenticationException {
        ResponseData responseData = ResponseData.newInstance();
        responseData.setData(authService.login(username, password));
        responseData.setSuccess();
        // 登录成功会返回Token给用户
        return responseData;
    }
}
