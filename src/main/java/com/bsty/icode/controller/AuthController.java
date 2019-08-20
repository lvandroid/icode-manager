package com.bsty.icode.controller;

import com.bsty.icode.ResponseData;
import com.bsty.icode.bean.Role;
import com.bsty.icode.bean.User;
import com.bsty.icode.request.LoginRequest;
import com.bsty.icode.request.LogoutRequest;
import com.bsty.icode.response.LoginResponse;
import com.bsty.icode.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/api")
public class AuthController {
    @Autowired
    private AuthService authService;

    /**
     * 登录
     */
    @PostMapping(value = "/user/login")
    public ResponseData<LoginResponse> login(@RequestBody LoginRequest loginRequest) throws AuthenticationException {
        ResponseData responseData = ResponseData.newInstance();
        if (loginRequest != null) {
            String token = authService.login(loginRequest.getUsername(), loginRequest.getPassword());
            if (token != null && !token.equals("")) {
                responseData.setSuccess();
                responseData.setData(new LoginResponse(token));
            }
        }
        // 登录成功会返回Token给用户
        log.debug(responseData.toString());
        return responseData;
    }

    @GetMapping(value = "/user/info")
    public ResponseData<User> getUserInfo(@RequestParam("token") String token) throws Exception {
        ResponseData responseData = ResponseData.newInstance();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            User user =
                    (User) authentication.getPrincipal();
            if (user != null) {
                List<Role> roles = user.getAuthorities();
                if (roles!=null&&!roles.isEmpty()){
                    for (Role role:roles){

                    }
                }
                responseData.setData(user);
                responseData.setSuccess();
            }
        }
        log.debug(responseData.toString());
        return responseData;
    }

    @PostMapping(value = "/user/logout")
    public ResponseData logout(HttpServletRequest request) throws Exception {
        ResponseData responseData = ResponseData.newInstance();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, null, authentication);
        }
        responseData.setSuccess();
        return responseData;
    }
}
