package com.bsty.icode.bean;

import lombok.Data;

@Data
public class HandInfo {

    private long id;
    private long studentId;
    private String campus;
    private long createTime;
    private String channel;
    private long clerkId;
    private long salesmanId;
    private long telemarketerId;

    public HandInfo() {
    }

    public HandInfo(long studentId, String campus, long createTime, String channel, long clerkId, long salesmanId, long telemarketerId) {
        this.studentId = studentId;
        this.campus = campus;
        this.createTime = createTime;
        this.channel = channel;
        this.clerkId = clerkId;
        this.salesmanId = salesmanId;
        this.telemarketerId = telemarketerId;
    }
}
