package com.bsty.icode.controller;

import com.bsty.icode.ResponseData;
import com.bsty.icode.dto.RoleDTO;
import com.bsty.icode.request.RoleVO;
import com.bsty.icode.service.RoleService;
import com.bsty.icode.service.RouterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/api/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private RouterService routerService;


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
            roleService.addRole(dto, vo.getRouterIds());
        } catch (Exception e) {
            log.error(e.getMessage());
            responseData.setError();
        }
        return responseData;
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseData delRole(@PathVariable long id) {
        ResponseData responseData = ResponseData.newInstance();
        try {
            roleService.delRole(id);
            responseData.setSuccess();
        } catch (Exception e) {
            log.error(e.getMessage());
            responseData.setError();
        }
        return responseData;
    }

    @PutMapping(value = "/update/{id}")
    public ResponseData updateRole(@PathVariable long id, @RequestBody RoleVO vo) {
        ResponseData responseData = ResponseData.newInstance();
        if (vo == null) {
            responseData.setError("没有传入角色参数");
            return responseData;
        }
        RoleDTO role = vo.getRole();
        List<Long> routerIds = vo.getRouterIds();
        if (role == null) {
            responseData.setError("没有传入角色参数");
            return responseData;
        }
        List<Long> dbRouterIds = routerService.findAllIdsByByRoleId(role.getId());
        try {
            roleService.updateRole(role);
            if (routerIds != null) {
                if (dbRouterIds == null || dbRouterIds.isEmpty()) {
                    routerService.addRouters(role.getId(), routerIds);
                } else {
                    List<Long> retainIds = new ArrayList<>();
                    retainIds.addAll(dbRouterIds);//数据库中routers和请求参数中的交集
                    retainIds.retainAll(routerIds);
                    /**
                     * 取到需要新插入的router_id
                     */
                    routerIds.removeAll(retainIds);
                    if (!routerIds.isEmpty()) {
                        routerService.addRouters(role.getId(), routerIds);
                    }
                    /**
                     * 取需要删除的router_id
                     */
                    dbRouterIds.removeAll(retainIds);
                    if (!dbRouterIds.isEmpty()) {
                        routerService.deleteRouters(role.getId(), dbRouterIds);
                    }
                }

            }
            responseData.setSuccess();
        } catch (Exception e) {
            log.error(e.getMessage());
            responseData.setError();
        }
        return responseData;
    }
}
