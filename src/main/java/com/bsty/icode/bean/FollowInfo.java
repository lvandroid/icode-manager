package com.bsty.icode.bean;

import lombok.Data;

@Data
public class FollowInfo {

    private long id;
    private long studentId;
    private String consultMethod;
    private String intention;
    private String courses;
    private String status;
    private String keyword;
    private long updateTime;

    public FollowInfo() {
    }

    public FollowInfo(long studentId, String consultMethod, String intention, String courses, String status, String keyword, long updateTime) {
        this.studentId = studentId;
        this.consultMethod = consultMethod;
        this.intention = intention;
        this.courses = courses;
        this.status = status;
        this.keyword = keyword;
        this.updateTime = updateTime;
    }
}
