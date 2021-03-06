package com.bsty.icode.service.impl;

import com.bsty.icode.bean.Router;
import com.bsty.icode.dao.RouterDao;
import com.bsty.icode.service.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouterServiceImpl implements RouterService {
    @Autowired
    private RouterDao routerDao;

    @Override
    public List<Router> getRouterList() {
        return routerDao.selectAll();
    }

    @Override
    public List<Router> findAsyncRouter() {
        return routerDao.findAsync();
    }

    @Override
    public List<Router> findByRoleId(long roleId) {
        return routerDao.findByRoleId(roleId);
    }

    @Override
    public List<Long> findAllIdsByByRoleId(long roleId) {
        return routerDao.findIdsByRoleId(roleId);
    }

    @Override
    public void deleteByRoleId(long roleId) {
        routerDao.deleteByRoleId(roleId);
    }

    @Override
    public void addRouters(long roleId, List<Long> routerIds) {
        if (routerIds!=null&&!routerIds.isEmpty()) {
            routerDao.addRouters(roleId, routerIds);
        }
    }

    @Override
    public void deleteRouters(long roleId, List<Long> routerIds) {
        routerDao.deleteRouters(roleId, routerIds);
    }

}
