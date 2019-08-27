package com.bsty.icode.request;

import lombok.Data;

import java.util.List;

@Data
public class UserVo {
    private String username;
    private String password;
    private long rootRoleId;
    private List<Long> roleIds;
}
