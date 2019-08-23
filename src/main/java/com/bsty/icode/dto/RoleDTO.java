package com.bsty.icode.dto;

import com.bsty.icode.bean.Router;
import com.bsty.icode.tree.TreeBuilder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RoleDTO {
    private Long id;
    private String name;
    private String description;
    private boolean rootRole;
    private List<TreeBuilder.Node> routers;
    private List<Long> routerIds;

    public List<Long> getRouterIds() {
        if (routers != null && !routers.isEmpty()) {
            routerIds = new ArrayList<>();
            routers.forEach(r -> {
                routerIds.add(r.getId());
            });
        }
        return routerIds;
    }
}
