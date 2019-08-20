package com.bsty.icode.service;

import com.bsty.icode.bean.Router;

import java.util.List;

public interface RouterService {
    List<Router> getRouterList();
    List<Router> findAsyncRouter();
    List<Router> findByRoleId(long roleId);
}
