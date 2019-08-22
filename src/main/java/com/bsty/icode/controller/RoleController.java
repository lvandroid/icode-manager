package com.bsty.icode.controller;

import com.bsty.icode.ResponseData;
import com.bsty.icode.bean.Role;
import com.bsty.icode.dto.RoleDTO;
import com.bsty.icode.request.RoleVO;
import com.bsty.icode.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/api/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/list")
    public ResponseData<List<RoleDTO>> findAllRole() {
        return ResponseData.successInstance(roleService.findAll());
    }

    @PostMapping(value = "/add")
    public ResponseData<RoleDTO> addRole(@RequestBody RoleVO vo) {
        ResponseData responseData = ResponseData.newInstance();
        long roleId;
        try {
            if (vo == null) {
                responseData.setError();
                return responseData;
            }
            RoleDTO dto = vo.getRole();
            if (dto == null) {
                responseData.setError();
                return responseData;
            }
            roleService.addRole(dto, vo.getRouteIds());
        } catch (Exception e) {
            log.error(e.getMessage());
            responseData.setError();
        }
        return responseData;
    }
}
