package com.bsty.icode.controller;

import com.bsty.icode.ResponseData;
import com.bsty.icode.bean.User;
import com.bsty.icode.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.bsty.icode.ResponseData.CODE_SUCCESS;
import static com.bsty.icode.ResponseData.MSG_SUCCESS;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/query")
    public ResponseData<List<User>> testQuery(HttpServletRequest request, String name) {
        ResponseData responseData = new ResponseData();
        responseData.setData(userService.selectUserByName(name));
        responseData.setSuccess();
        log.debug(request.getRequestURL().toString());
        return responseData;
    }

    @RequestMapping("/add")
    public ResponseData add(@RequestBody User user) {
        ResponseData responseData = new ResponseData();
        userService.addUser(user);
        responseData.setSuccess();
        return responseData;
    }

}
