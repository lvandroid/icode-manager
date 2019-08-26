package com.bsty.icode.dto;

import com.bsty.icode.bean.Role;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO {
    private long id;
    private String username;
    private String password;
    private String roleNames;
    private List<Role> roles;
    private List<Long> roleIds;

    public List<Long> getRoleIds() {
        if (roles != null && !roles.isEmpty()) {
            roleIds = new ArrayList<>();
            for (Role role : roles) {
                roleIds.add(role.getId());
            }
        }
        return roleIds;
    }
}
