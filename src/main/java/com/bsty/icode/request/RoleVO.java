package com.bsty.icode.request;

import com.bsty.icode.dto.RoleDTO;
import lombok.Data;

import java.util.List;

@Data
public class RoleVO {
    private RoleDTO role;
    private List<Long> routeIds;
}
