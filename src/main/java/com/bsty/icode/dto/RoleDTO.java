package com.bsty.icode.dto;

import com.bsty.icode.bean.Router;
import lombok.Data;

import java.util.List;

@Data
public class RoleDTO {
    private Long id;
    private String name;
    private String description;
    private boolean rootRole;
    private List<Router> routers;
}
