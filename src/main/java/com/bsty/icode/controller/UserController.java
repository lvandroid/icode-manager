package com.bsty.icode.controller;

import com.bsty.icode.ListResultData;
import com.bsty.icode.ResponseData;
import com.bsty.icode.dto.UserDTO;
import com.bsty.icode.reqparams.UserParamDTO;
import com.bsty.icode.request.UserVo;
import com.bsty.icode.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
            //对密码加密保存
            vo.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
            userService.addUser(vo);
            responseData.setSuccess();
        } catch (Exception e) {
            log.error(e.getMessage());
            responseData.setError();
        }
        return responseData;

    }

    @PostMapping("/list")
    public ResponseData<List<UserDTO>> getUserList(@RequestBody UserParamDTO params) {
        Page page = PageHelper.startPage(params.getPageNum(), params.getPageSize());
        ResponseData responseData = ResponseData.newInstance();

        try {
            ListResultData<UserDTO> result = new ListResultData<>();
            List<UserDTO> dtos = userService.getAll(params);
            result.setPage(page);
            responseData.setTotal(page.getTotal());
            if (dtos != null && !dtos.isEmpty()) {
//                dtos.forEach(dto -> {
//                    dto.setRootRoleId(userService.getRootRole(dto.getId()));
//                    dto.setRoleIds(userService.getRoles(dto.getId()));
//                });
                for (int i = 0; i < dtos.size(); i++) {
                    UserDTO dto = dtos.get(i);
                    dtos.get(i).setRoleIds(userService.getRoles(dto.getId()));
                    dtos.get(i).setRootRoleId(userService.getRootRole(dto.getId()));
                }
            }
            result.setList(dtos);
            responseData.setData(result);
        } catch (Exception e) {
            responseData.setError();
            log.error(e.getMessage());
        }

        return responseData;
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseData deleteUser(@PathVariable long userId) {
        ResponseData responseData = ResponseData.newInstance();
        try {
            userService.delUser(userId);
            responseData.setSuccess();
        } catch (Exception e) {
            log.error(e.getMessage());
            responseData.setError();
        }
        return responseData;
    }

    @PutMapping("/updatePwd/{userId}")
    public ResponseData updatePwd(@PathVariable long userId, @RequestBody UserVo vo) {
        if (vo == null) {
            return ResponseData.errMsgInstance("参数传入不正确");
        }
        String pwd = vo.getPassword();
        if (pwd == null || pwd.isEmpty()) {
            return ResponseData.errMsgInstance("参数传入不正确");
        }
        ResponseData responseData = ResponseData.newInstance();
        try {
            userService.updatePwd(userId,
                    DigestUtils.md5DigestAsHex(pwd.getBytes()));
            responseData.setSuccess();
        } catch (Exception e) {
            responseData.setError();
            log.error(e.getMessage());
        }
        return responseData;
    }

    @PutMapping("/updateRoles/{userId}")
    public ResponseData updateUserRoles(@PathVariable long userId, @RequestBody UserVo vo) {
        if (vo == null) {
            return ResponseData.errMsgInstance("参数传入不正确");
        }
        ResponseData responseData = ResponseData.newInstance();
        try {
            userService.updateUserRoles(vo);
            responseData.setSuccess();
        } catch (Exception e) {
            responseData.setError();
            log.error(e.getMessage());
        }
        return responseData;
    }
}
