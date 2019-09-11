package com.bsty.icode.bean;

import lombok.Data;

@Data
public class CommunicateInfo {
    private long id;
    private long studentId;
    private String content;
    private long revisitRemind;
    private long createTime;

    public CommunicateInfo() {
    }

    public CommunicateInfo(long studentId, String content, long revisitRemind, long createTime) {
        this.studentId = studentId;
        this.content = content;
        this.revisitRemind = revisitRemind;
        this.createTime = createTime;
    }
}
