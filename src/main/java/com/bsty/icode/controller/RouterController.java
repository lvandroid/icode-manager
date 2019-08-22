package com.bsty.icode.controller;

import com.bsty.icode.ResponseData;
import com.bsty.icode.bean.Router;
import com.bsty.icode.service.RouterService;
import com.bsty.icode.tree.TreeBuilder;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/api/router")
public class RouterController {
    @Autowired
    private RouterService routerService;

    @GetMapping(value = "/list")
    public ResponseData<JSONArray> findAsyncRouter() {
        List<Router> routers = routerService.findAsyncRouter();
        JSONArray jsonArray = new TreeBuilder().buildTree(routers);
        return ResponseData.successInstance(jsonArray);
    }


    @GetMapping(value = "/list/{roleId}")
    public ResponseData<JSONArray> findByRoleId(@PathVariable long roleId) {
        List<Router> routers = routerService.findByRoleId(roleId);
        JSONArray jsonArray = new TreeBuilder().buildTree(routers);
        return ResponseData.successInstance(jsonArray);
    }

}
