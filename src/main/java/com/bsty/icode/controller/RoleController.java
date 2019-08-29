package com.bsty.icode.controller;

import com.bsty.icode.ResponseData;
import com.bsty.icode.dto.RoleDTO;
import com.bsty.icode.request.RoleVO;
import com.bsty.icode.service.PermissionService;
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
    @Autowired
    private PermissionService permissionService;

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
            roleService.addRole(dto, vo.getRouterIds(), vo.getPermissionIds());
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
        List<Long> permissionIds = vo.getPermissionIds();
        if (role == null) {
            responseData.setError("没有传入角色参数");
            return responseData;
        }
        long roleId = role.getId();
        try {
            roleService.updateRole(role);
            parseRouterPermissions(roleId, routerIds, permissionIds);
            responseData.setSuccess();
        } catch (Exception e) {
            log.error(e.getMessage());
            responseData.setError();
        }
        return responseData;
    }

    private void parseRouterPermissions(long roleId, List<Long> routerIds, List<Long> permissionIds) {
        List<Long> dbRouterIds = routerService.findAllIdsByByRoleId(roleId);
        List<Long> dbPermissionIds = permissionService.findAllIdsByByRoleId(roleId);
        /**
         * 更新动态路由
         */
        if (routerIds != null) {
            if (dbRouterIds == null || dbRouterIds.isEmpty()) {
                routerService.addRouters(roleId, routerIds);
            } else {
                List<Long> retainIds = new ArrayList<>();
                retainIds.addAll(dbRouterIds);//数据库中routers和请求参数中的交集
                retainIds.retainAll(routerIds);
                /**
                 * 取到需要新插入的router_id
                 */
                routerIds.removeAll(retainIds);
                if (!routerIds.isEmpty()) {
                    routerService.addRouters(roleId, routerIds);
                }
                /**
                 * 取需要删除的router_id
                 */
                dbRouterIds.removeAll(retainIds);
                if (!dbRouterIds.isEmpty()) {
                    routerService.deleteRouters(roleId, dbRouterIds);
                }
            }
        }
        /**
         * 更新权限
         */
        if (dbPermissionIds == null || dbPermissionIds.isEmpty()) {
            permissionService.addPermissions(roleId, permissionIds);
        } else {
            List<Long> retainIds = new ArrayList<>();
            retainIds.addAll(dbPermissionIds);
            retainIds.retainAll(permissionIds);
            /**
             * 取到需要新插入的permission_id
             */
            permissionIds.removeAll(retainIds);
            if (!permissionIds.isEmpty()) {
                permissionService.addPermissions(roleId, permissionIds);
            }
            /**
             * 取需要删除的permission_id
             */
            dbPermissionIds.removeAll(retainIds);
            if (!dbPermissionIds.isEmpty()) {
                permissionService.deletePermissions(roleId, dbPermissionIds);
            }
        }
    }

}
