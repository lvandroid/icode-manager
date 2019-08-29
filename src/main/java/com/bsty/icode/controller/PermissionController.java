package com.bsty.icode.controller;

import com.bsty.icode.ResponseData;
import com.bsty.icode.bean.Permission;
import com.bsty.icode.service.PermissionService;
import com.bsty.icode.tree.TreeBuilder;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @GetMapping(value = "/list")
    public ResponseData<JSONArray> findAsyncPermission() {
        List<Permission> permissions = permissionService.findAsyncPermission();
        JSONArray jsonArray = new TreeBuilder().buildTree(permissions);
        return ResponseData.successInstance(jsonArray);
    }

    @GetMapping(value = "/list/{roleId}")
    public ResponseData<JSONArray> findByRoleId(@PathVariable long roleId) {
        List<Permission> permissions = permissionService.findByRoleId(roleId);
        JSONArray jsonArray = new TreeBuilder().buildTree(permissions);
        return ResponseData.successInstance(jsonArray);
    }
}
