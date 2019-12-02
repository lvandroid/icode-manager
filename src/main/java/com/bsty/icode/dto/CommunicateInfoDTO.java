package com.bsty.icode.dto;

import lombok.Data;

@Data
public class CommunicateInfoDTO {
    private long id;
    private long studentId;
    private long staffId;
    private String content;
    private String staffName;
    private long revisitRemind;
    private long createTime;
}
