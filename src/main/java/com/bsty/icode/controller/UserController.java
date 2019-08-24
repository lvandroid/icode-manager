package com.bsty.icode.controller;

import com.bsty.icode.ResponseData;
import com.bsty.icode.request.UserVo;
import com.bsty.icode.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Slf4j
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseData<String> addUser(@RequestBody UserVo vo) {
        ResponseData responseData = ResponseData.newInstance();
        if (vo == null) {
            return ResponseData.errMsgInstance("参数传入不正确");
        }
        String username = vo.getUsername();
        String password = vo.getPassword();
        if (username == null || username.length() < 3 || password == null || password.length() < 6) {
            return ResponseData.errMsgInstance("用户参数传入不正确");
        }

        try {
            userService.addUser(vo);
            responseData.setSuccess();
        } catch (Exception e) {
            log.error(e.getMessage());
            responseData.setError();
        }
        return responseData;

    }
}
