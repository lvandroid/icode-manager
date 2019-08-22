package com.bsty.icode.dto;

import lombok.Data;

@Data
public class RoleDTO {
    private Long id;
    private String name;
    private String description;
    private boolean rootRole;
}
