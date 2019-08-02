//package com.bsty.icode.controller;
//
//import com.bsty.icode.ResponseData;
//import com.bsty.icode.bean.User;
//import com.bsty.icode.service.UserService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//
//@RestController
//@Slf4j
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @RequestMapping("/login")
//    public ResponseData<String> login(HttpServletRequest request, String name) {
//        ResponseData responseData = new ResponseData();
//        User user = userService.selectUserByName(name);
//        if (user == null) {
//            responseData.setErrCode(ResponseData.CODE_ERROR);
//            responseData.setErrMsg("用户不存在");
//        } else {
//            responseData.setData(userService.selectUserByName(name));
//            responseData.setSuccess();
//        }
//        return responseData;
//    }
//}
